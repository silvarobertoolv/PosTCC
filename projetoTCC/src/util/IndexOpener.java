/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package util;
import java.io.File;
import java.io.IOException;
import org.apache.lucene.index.DirectoryReader;
import org.apache.lucene.index.IndexReader;
import org.apache.lucene.store.FSDirectory;

/**
 * Class to Get the Lucene Index Reader
 */
public class IndexOpener {
    
    public static IndexReader GetIndexReader() throws IOException {
        IndexReader indexReader = DirectoryReader.open(FSDirectory.open(new File(Configuration.INDEX_DIRECTORY)));
        return indexReader;
    }

    /**
     * Returns the total number of documents in the index
     * @return
     * @throws IOException 
     */
    public static Integer TotalDocumentInIndex() throws IOException
    {
        Integer maxDoc = GetIndexReader().maxDoc();
        GetIndexReader().close();
        return maxDoc;
    }
}