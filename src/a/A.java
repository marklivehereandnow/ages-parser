/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package a;

import com.livehereandnow.ages.util.CardContentParser;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

/**
 *
 * @author max
 */
public class A {

    /**
     * @param args the command line arguments
     */
//
//public class Main {
    /**
     * @param args the command line arguments
     */
//    public static void main(String[] args) {
    // TODO code application logic here
//        System.out.println("這是max cards項目");
    private static final String PERSISTENCE_UNIT_NAME = "APU";//項目名稱
    private static EntityManagerFactory factory;

    public static void main(String[] args) {
        int cnt=0;
        CardContentParser parser = new CardContentParser();
        factory = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);
        EntityManager em = factory.createEntityManager();
        // read the existing entries and write to console
        Query q = em.createQuery("select t from Cards t ");
        List<Cards> list = q.getResultList();
        for (Cards cards : list) {
            
            parser.doParse(cards.getContent());
            if(parser.isComplete()){
//                System.out.println("123456789");
//                System.out.println(cards.toString());
                
                cnt++;
            }
            else{
                System.out.println(cards.toString());
                System.out.println("");
            
            }
        }
        System.out.println("已解析/牌數: " + cnt+"/"+list.size());
    }

}
