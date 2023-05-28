/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.password.generator;

import java.util.Random;

/**
 *
 * @author mauricehaghighi
 */
public class Generator {
 

    public String generate(int length, boolean special) {

        String characters
                = "ABCDEFGHIJKLMNOPQRSTUVWXYZ"
                + "abcdefghijklmnopqrstuvwxyz"
                + "0123456789";

        if (special) {
            characters += "!@#$%&*-_+=?";
        }

        StringBuilder sb = new StringBuilder(length);
        Random random = new Random();
        
        for(int i =0;i<length;i++){
            
            int rng=random.nextInt(characters.length());
            
            char randomChar = characters.charAt(rng);
            
            sb.append(randomChar);
            
        }
        
        System.out.println(sb.toString());
        return sb.toString();

    }

}
