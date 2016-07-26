/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package util;

/**
 * Class to calculate cosine similarity
 * @author Mubin Shrestha
 */
public class CosineSimilarity {    
    public static double CosineSimilarity(DocVector d1,DocVector d2) {
        double cosinesimilarity;
        try {
            cosinesimilarity = (d1.vector.dotProduct(d2.vector))
                    / (d1.vector.getNorm() * d2.vector.getNorm());
        } catch (Exception e) {
            return 0.0;
        }
        return cosinesimilarity;
    }
}