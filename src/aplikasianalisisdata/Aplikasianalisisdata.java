/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package aplikasianalisisdata;

import java.util.List;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;


/**
 *
 * @author RPL
 */
public class Aplikasianalisisdata {

   
    public static void main(String[] args) {
       String fileName = "data.txt"; 
       
        try {
            List<Double> data = readDataFromFile(fileName);
            
            if (!data.isEmpty()) {
                int dataSize = data.size();
                double sum = 0;
                double max = Double.MIN_VALUE;
                
                for(double value : data) {
                    sum += value;
                    if(value > max) {
                        max = value;
                    }
                }
                double average = sum / dataSize;
                
                System.out.println("Statistik Data:");
                System.out.println("Jumlah Data: " +dataSize);
                System.out.println("Rata-rata: " +average);
                System.out.println("Nilai maksimum: " +max);
            } else {
                System.out.println("Tidak ada data dalam file");
            }
        } catch (IOException e) {
            System.err.println("Terjadi kesalahan saat membaca file:  " +e.getMessage());
        } finally {
           System.out.println("Aplikasi Selesai");
        }
    }
    

    public static List<Double> readDataFromFile(String fileName) throws FileNotFoundException, IOException {
        List<Double> data = new ArrayList<>();
        
         try(BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = reader.readLine()) != null) {
                try {
                    double value = Double.parseDouble(line);
                    data.add(value);
                } catch (NumberFormatException e) {
                  System.err.println("Kesalahan dalam format data: " + line);
                }
            }
        }
        return data;
    }
    
}
