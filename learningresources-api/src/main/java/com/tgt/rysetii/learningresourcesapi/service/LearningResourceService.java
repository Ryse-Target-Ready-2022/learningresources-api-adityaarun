package com.tgt.rysetii.learningresourcesapi.service;
import com.tgt.rysetii.learningresourcesapi.entity.LearningResource;
import com.tgt.rysetii.learningresourcesapi.entity.LearningResourceStatus;
import org.springframework.cglib.core.Local;

import java.io.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class LearningResourceService {



    // function to get learningresources from csv file
    public List<LearningResource> getLearningResources(){
        List<LearningResource> LearningResourceList= new ArrayList<>();
        try{
            BufferedReader bufferedReader= new BufferedReader(new FileReader("LearningResource.csv"));
            String line="";
            while((line=bufferedReader.readLine())!=null){
                String[] attr=line.split(",");
                int id=Integer.parseInt(attr[0]);
                String name=attr[1];
                Double cp=Double.parseDouble(attr[2]);
                Double sp= Double.parseDouble(attr[3]);
                LearningResourceStatus lrs= LearningResourceStatus.valueOf(attr[4]);
                DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
                LocalDate createdDate = LocalDate.parse(attr[5], dateFormatter);
                LocalDate publishedDate = LocalDate.parse(attr[6], dateFormatter);
                LocalDate retiredDate = LocalDate.parse(attr[7], dateFormatter);

                LearningResource lr = new LearningResource(id,name,cp,sp,lrs,createdDate,publishedDate,retiredDate);
                LearningResourceList.add(lr);
            }
        }
        catch (IOException e){
            e.printStackTrace();
        }
        return LearningResourceList;
    }


    //function to save data to csv file
    public void saveLearningResources(List<LearningResource> LearningResourceList){
        try{
            BufferedWriter bufferedWriter= new BufferedWriter(new FileWriter("LearningResource.csv"));
            for(LearningResource learningResource: LearningResourceList){
                bufferedWriter.newLine();
                StringBuffer line= new StringBuffer();
                line.append(learningResource.getId());
                line.append(",");
                line.append(learningResource.getName());
                line.append(",");
                line.append(learningResource.getCostPrice());
                line.append(",");
                line.append(learningResource.getCostPrice());
                line.append(",");
                line.append(learningResource.getSellingPrice());
                line.append(",");
                line.append(learningResource.getProductStatus());
                line.append(",");
                line.append(learningResource.getCreatedDate());
                line.append(",");
                line.append(learningResource.getPublishedDate());
                line.append(",");
                line.append(learningResource.getRetiredDate());
                bufferedWriter.write(line.toString());
            }
            bufferedWriter.flush();
            bufferedWriter.close();
        }
        catch(IOException e){
            e.printStackTrace();
        }
    }
}
