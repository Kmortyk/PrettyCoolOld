package com.example.user1.prettycool.Classes.Persons;

import com.example.user1.prettycool.Classes.Persons.AllItems;
import com.example.user1.prettycool.Classes.Persons.GlobalInformation;
import com.example.user1.prettycool.Classes.Persons.HeroParameters;
import com.example.user1.prettycool.Classes.Persons.MonstersParameters;

import java.util.Arrays;
import java.util.HashMap;

/**
 * Created by user1 on 12.04.2016.
 */
public class UniqueMas{

    HashMap<String,Integer> hm = new HashMap<String,Integer>();
    String s;

   public UniqueMas(String[][] dynamicsMap,HashMap<String,Object> objects,GlobalInformation globalInformation){
        for (int i = 0; i < dynamicsMap.length; i++) {
            for (int j = 0; j < dynamicsMap.length; j++) {
                s = dynamicsMap[i][j];

                if(!hm.containsKey(s)){
                hm.put(s,0);
            }else{
                hm.put(s,hm.get(s)+1);
            }
                dynamicsMap[i][j]+=hm.get(s);


                if(Arrays.asList(globalInformation.monstersId).contains(s)){
                objects.put(dynamicsMap[i][j],new MonstersParameters(s));
                }
                if(Arrays.asList(globalInformation.itemId).contains(s)){
                    objects.put(dynamicsMap[i][j],new AllItems(s));
                }
                if(s=="H"){
                    objects.put(dynamicsMap[i][j],new HeroParameters());
                }
            }

        }
    }

}
