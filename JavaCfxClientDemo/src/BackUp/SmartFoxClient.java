/*package BackUp;

import com.smartfoxserver.v2.core.SFSEvent;

public class SmartFoxClient
{
       private var smartFoxServer : SmartFox;

       public function SmartFoxClient()
       {
               smartFoxServer = new SmartFox();

               //I'm not including the standard login etc events, just the one for listening
               //for the example server extension responses.
               //We're going to connect to a room. Once we've connected to the room ok, the server should 
               //dispatch an extension response via UserJoinedRoomHandler, which is caught in the 
               //onExtensionResponse() function below.
               smartFoxServer.addEventListener(SFSEvent.EXTENSION_RESPONSE, onExtensionResponse);

               //Connect to your server instance
               smartFoxServer.connect("localhost", 9933);

               //Once connected (use event listeners), we want to Login to a SmartFoxServer Zone:
               smartFoxServer.send(new LoginRequest("MyUsername", "MyPassword", "Zone, e.g SimpleChat"));

               //Once logged in to the zone (again, use event listeners), we can join a room:
               smartFoxServer.send(new JoinRoomRequest("MyRoomName"));

               //At this point, we have hopefully successfully joined the SmartFoxServer room, and now we'll
               //test that the server can pick up our events and accompanying data object...
               smartFoxServer.send(new ExtensionRequest("example_request", anISFSObject));

               //You should see the trace message from SimpleRequestHandler output in your SmartFoxServer console.
       }

       public function onExtensionResponse(evt : SFSEvent) : void
       {
               trace("Got an expansion response");
               var params : ISFSObject = evt.params.params;
               var cmd : String = evt.params.cmd;

               switch(cmd)
               {
                       //Refer to the java UserJoinedRoomHandler class to see where
                       //this string is sent from
                       case "server_return_data":
                               trace("Returned value of params.foo: " + params.getInt("foo");
                               break;
               }
       }
*/