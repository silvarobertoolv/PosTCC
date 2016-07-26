/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package principal;

import java.io.IOException;
import org.apache.lucene.store.LockObtainFailedException;
import util.CosineSimilarity;
import util.DocVector;
import util.Indexer;
import util.VectorGenerator;

/**
 *
 * @author roliveira
 */
public class Main {
    
      public static void main(String[] args) throws LockObtainFailedException, IOException
    {
        getCosineSimilarity();
    }
    
    public static void getCosineSimilarity() throws LockObtainFailedException, IOException
    {
       Indexer index = new Indexer();
       index.index();
       VectorGenerator vectorGenerator = new VectorGenerator();
       vectorGenerator.GetAllTerms();       
       DocVector[] docVector = vectorGenerator.GetDocumentVectors(); // getting document vectors
       for(int i = 0; i < docVector.length; i++)
       {
           double cosineSimilarity = CosineSimilarity.CosineSimilarity(docVector[1], docVector[i]);
           System.out.println("Cosine Similarity Score between document 0 and "+i+"  = " + cosineSimilarity);
       }    
    }
    
}
