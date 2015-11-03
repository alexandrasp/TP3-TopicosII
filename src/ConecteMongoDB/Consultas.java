/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ConecteMongoDB;

import OOClasses.Hero;
import com.mongodb.BasicDBObject;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import java.util.ArrayList;
import org.bson.Document;

/**
 *
 * @author alexandra
 */
public class Consultas {
    
    public ArrayList<Hero> buscaGeral(String termo){
        ArrayList<Hero> resultados = new ArrayList<>();
               
        return resultados;
    }
    
    public ArrayList<Hero> buscaHero(String hero) {
        ArrayList<Hero> resultados = new ArrayList<>();
        

       
        return resultados;
    }
    
    public ArrayList<Hero> buscaSide(String side) {
        ArrayList<Hero> resultados = new ArrayList<>();
        DBCollection colecao = MongoConnection.getInstance().getDB().getCollection("heroesdata");
        BasicDBObject query = new BasicDBObject("Side", side);
        DBCursor cursor;
                
        cursor = colecao.find(query).sort(new BasicDBObject("Initial"+"."+"Strength", -1));
        
        try {
            while (cursor.hasNext()) {
                System.out.println(cursor.next());
            }
        } finally {
            cursor.close();
        }
        System.out.println(colecao.count(query));
        
        return resultados;
    }
    
    public ArrayList<Hero> buscaFunction(String function){
        ArrayList<Hero> resultados = new ArrayList<>();
        DBCollection colecao = MongoConnection.getInstance().getDB().getCollection("heroesdata");
        
        DBCursor cursor;
        
        BasicDBObject query = new BasicDBObject("SuggestedRoleLevels"+"."+function, new BasicDBObject("$gt", 1));
        
        cursor = colecao.find(query).sort(new BasicDBObject("SuggestedRoleLevels"+"."+function, -1));
        
        try {
            while (cursor.hasNext()) {
                System.out.println(cursor.next());
            }
        } finally {
            cursor.close();
        }
        System.out.println(colecao.count(query));
        
        return resultados;
    }
    
    public ArrayList<Hero> buscaSkill(String skill){
        ArrayList<Hero> resultados = new ArrayList<>();
        
        
        return resultados;
    }
}