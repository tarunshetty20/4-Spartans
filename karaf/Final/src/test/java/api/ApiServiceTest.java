//Test Case Contribution: Anu Sebastian, Saloni Bhaleroa, Tarun Shetty, Hemambujam Veeraraghavan

package api;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

import org.apache.camel.test.blueprint.CamelBlueprintTestSupport;
import org.junit.Assert;
import org.junit.Test;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

public class ApiServiceTest extends CamelBlueprintTestSupport {

   @Override
    protected String getBlueprintDescriptor() {
        return "OSGI-INF/blueprint/rest-api.xml";
    }

   //Anu Sebastian
   @Test
    public void testhome() throws Exception {
        InitialService svc = context().getRegistry().lookupByNameAndType("ApiService", InitialService.class);

       // setup some pre-existing orders
        svc.setupInitialOrders();
        // use restlet component to get the order
        String response = template.requestBody("restlet:http://localhost:8080/orders/home?restletMethod=GET", null, String.class);
        Assert.assertNotNull(response);
        
       Gson gson = new Gson();
        Type listType = new TypeToken<ArrayList<Tweet>>(){}.getType();
        List<Tweet> tweets = gson.fromJson(response, listType);
        Assert.assertNotNull(tweets);
        Assert.assertNotEquals(tweets.size(), 0);         
   }
   
   //Saloni Bhaleroa
  @Test
   public void testmentionstimeline() throws Exception {
       InitialService svc = context().getRegistry().lookupByNameAndType("ApiService", InitialService.class);

      // setup some pre-existing orders
       svc.setupInitialOrders();
       // use restlet component to get the order
       String response = template.requestBody("restlet:http://localhost:8080/orders/twitter?restletMethod=GET", null, String.class);
       Assert.assertNotNull(response);
       
      Gson gson = new Gson();
       Type listType = new TypeToken<ArrayList<Tweet>>(){}.getType();
       List<Tweet> tweets = gson.fromJson(response, listType);
       Assert.assertNotNull(tweets);
       Assert.assertNotEquals(tweets.size(), 0);         
  }
   //Tarun shetty
   @Test
   public void testuserstimeline() throws Exception {
       InitialService svc = context().getRegistry().lookupByNameAndType("ApiService", InitialService.class);

      // setup some pre-existing orders
       svc.setupInitialOrders();
       // use restlet component to get the order
       String response = template.requestBody("restlet:http://localhost:8080/orders/user_timeline?restletMethod=GET", null, String.class);
       Assert.assertNotNull(response);
       
      Gson gson = new Gson();
       Type listType = new TypeToken<ArrayList<Tweet>>(){}.getType();
       List<Tweet> tweets = gson.fromJson(response, listType);
       Assert.assertNotNull(tweets);
       Assert.assertNotEquals(tweets.size(), 0);         
  }
   //Hemambujam Veeraraghavan
   @Test
   public void testFriendsId() throws Exception {
       InitialService svc = context().getRegistry().lookupByNameAndType("ApiService", InitialService.class);

      // setup some pre-existing orders
       svc.setupInitialOrders();
       // use restlet component to get the order
       String response = template.requestBody("restlet:http://localhost:8080/orders/friends_list?restletMethod=GET", null, String.class);
       Assert.assertNotNull(response);
       
      Gson gson = new Gson();
       Type listType = new TypeToken<User>(){}.getType();
       User users = gson.fromJson(response, listType);
       Assert.assertNotNull(users);     
  }
   
   @Test
   public void testAccountSetting() throws Exception {
       InitialService svc = context().getRegistry().lookupByNameAndType("ApiService", InitialService.class);

      // setup some pre-existing orders
       svc.setupInitialOrders();
       // use restlet component to get the order
       String response = template.requestBody("restlet:http://localhost:8080/orders/account_settings?restletMethod=GET", null, String.class);
       Assert.assertNotNull(response);
       
      Gson gson = new Gson();
       Type listType = new TypeToken<AccountSettings>(){}.getType();
       AccountSettings account = gson.fromJson(response, listType);
       Assert.assertNotNull(account);        
  }
   //Anu Sebastian
   @Test
   public void testFollowersList() throws Exception {
       InitialService svc = context().getRegistry().lookupByNameAndType("ApiService", InitialService.class);

      // setup some pre-existing orders
       svc.setupInitialOrders();
       // use restlet component to get the order
       String response = template.requestBody("restlet:http://localhost:8080/orders/followers_list?restletMethod=GET", null, String.class);
       Assert.assertNotNull(response);
       
      Gson gson = new Gson();
       Type listType = new TypeToken<FollowersList>(){}.getType();
       FollowersList users = gson.fromJson(response, listType);
       Assert.assertNotNull(users);       
  }
   
   @Test
   public void testPrivacyPolicy() throws Exception {
       InitialService svc = context().getRegistry().lookupByNameAndType("ApiService", InitialService.class);

      // setup some pre-existing orders
       svc.setupInitialOrders();
       // use restlet component to get the order
       String response = template.requestBody("restlet:http://localhost:8080/orders/privacy_policy?restletMethod=GET", null, String.class);
       Assert.assertNotNull(response);
       
      Gson gson = new Gson();
       Type listType = new TypeToken<PrivacyPolicy>(){}.getType();
       PrivacyPolicy tweets = gson.fromJson(response, listType);
       Assert.assertNotNull(tweets);      
  }
//Saloni Bhaleroa
   @Test
   public void testDMEventLists() throws Exception {
       InitialService svc = context().getRegistry().lookupByNameAndType("ApiService", InitialService.class);

      // setup some pre-existing orders
       svc.setupInitialOrders();
       // use restlet component to get the order
       String response = template.requestBody("restlet:http://localhost:8080/orders/tos?restletMethod=GET", null, String.class);
       Assert.assertNotNull(response);
       
      Gson gson = new Gson();
       Type listType = new TypeToken<ToS>(){}.getType();
       ToS tweets = gson.fromJson(response, listType);
       Assert.assertNotNull(tweets);       
  }

}
