/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sonia.webapp.qrtravel.db;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.TypedQuery;
import org.apache.catalina.Host;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import sonia.webapp.qrtravel.Config;

/**
 *
 * @author th
 */
public class Database
{
  private final static Config CONFIG = Config.getInstance();

  private final static Logger LOGGER = LoggerFactory.getLogger(
    Database.class.getName());

    /** Field description */
  private final static String PERSISTANCE_UNIT_NAME = "qrPU";

  /** Field description */
  private final static Database SINGLETON = new Database();

  //~--- constructors ---------------------------------------------------------

  /**
   * Constructs ...
   *
   */
  private Database()
  {
    Map<String, String> properties = new HashMap<>();

    properties.put("javax.persistence.jdbc.url", CONFIG.getDbUrl());
    properties.put("javax.persistence.jdbc.user", CONFIG.getDbUser());
    properties.put("javax.persistence.jdbc.driver", CONFIG.getDbDriverClassName());
    properties.put("javax.persistence.jdbc.password", CONFIG.getDbPassword());

    this.entityManagerFactory = new org.hibernate.jpa
      .HibernatePersistenceProvider().createEntityManagerFactory(
      PERSISTANCE_UNIT_NAME, properties);
  }

  public static void initialize()
  {
    LOGGER.info("Initialize Database");
    for( RoomType rt : listRoomTypes())
    {
      System.out.println( rt );
    }
    
    Room room = findRoom( "123456" );
        
    System.out.println( room );
  }
  
  public static Room findRoom( String pin )
  {
    return getEntityManager().find( Room.class, pin );
  }
  
  private static EntityManager getEntityManager()
  {
    return SINGLETON.entityManagerFactory.createEntityManager();
  }
  
  public static List<RoomType> listRoomTypes()
  {
    List<Object[]> resultList;
    List<RoomType> result = null;
    
    TypedQuery<Object[]> query = getEntityManager().createNamedQuery(
      "listRoomTypes", Object[].class);

    try
    {
      resultList = query.getResultList();
      result = new ArrayList<>();

      for (Object[] o : resultList)
      {
        result.add((RoomType) o[0]);
      }

    }
    catch (javax.persistence.NoResultException e)
    {
      LOGGER.debug("list", e);
    }

    return result;
  }
  
  
  private final EntityManagerFactory entityManagerFactory;
}
