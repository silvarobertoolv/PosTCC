/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package util;

import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import org.apache.lucene.index.IndexReader;
import org.apache.lucene.index.Terms;
import org.apache.lucene.index.TermsEnum;
import org.apache.lucene.util.BytesRef;



/**
 * Class that will get all the terms in the index.
 */
public class AllTerms {
    private Map allTerms;
    Integer totalNoOfDocumentInIndex;
    IndexReader indexReader;
    
    public AllTerms() throws IOException
    {    
        allTerms = new HashMap<>();
        indexReader = IndexOpener.GetIndexReader();
        totalNoOfDocumentInIndex = IndexOpener.TotalDocumentInIndex();
    }
        
    public void initAllTerms() throws IOException
    {
        int pos = 0;
        for (int docId = 0; docId < totalNoOfDocumentInIndex; docId++) {
            Terms vector = indexReader.getTermVector(docId, Configuration.FIELD_CONTENT);
            TermsEnum termsEnum = null;
            termsEnum = vector.iterator(termsEnum);
            BytesRef text = null;
            while ((text = termsEnum.next()) != null) {
                String term = text.utf8ToString();
                allTerms.put(term, pos++);
            }
        }       
        
        //Update postition
        pos = 0;
        for (Iterator it = allTerms.entrySet().iterator(); it.hasNext();) {
            Entry<String,Integer> s = (Entry<String,Integer>) it.next();        
            System.out.println(s.getKey());
            s.setValue(pos++);
        }
    }
    
    public Map<String,Integer> getAllTerms() {
        return allTerms;
    }
}
