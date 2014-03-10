import java.util.Iterator;
import java.util.Map;

import sfs2x.client.SmartFox;
import sfs2x.client.core.BaseEvent;
import sfs2x.client.core.IEventListener;
import sfs2x.client.core.SFSEvent;
import sfs2x.client.requests.ExtensionRequest;
import sfs2x.client.requests.JoinRoomRequest;
import sfs2x.client.util.ClientDisconnectionReason;
import sfs2x.client.util.ConfigData;

import com.smartfoxserver.v2.entities.data.ISFSObject;
import com.smartfoxserver.v2.entities.data.SFSObject;
import com.smartfoxserver.v2.exceptions.SFSException;



public class SmartFoxClient
{
	
	public SmartFoxClient()
	{
		
		SmartFox smrtfx=new SmartFox();
		smrtfx.addEventListener(SFSEvent.CONNECTION, new IEventListener() {
			
			@Override
			public void dispatch(BaseEvent evnt) throws SFSException {
				// TODO Auto-generated method stub
				Map param=evnt.getArguments();
				Iterator keys=param.keySet().iterator();
				
				while(keys.hasNext())
				{
					//String key=(String) param.get(keys.next()+"");
					
					//System.out.println(key+"   "+param.get(key));
					System.out.println(keys.next());
				}
				
				if((Boolean)param.get("success"))
				{
					System.out.println("connection success");
				}
				else
				{
					System.out.println("connection failed");
				}
				
			}
		});
		 smrtfx.addEventListener(SFSEvent.CONNECTION_LOST, new IEventListener() 
	     {
	         public void dispatch(BaseEvent evt) throws SFSException 
	         {
	             String reason = (String)evt.getArguments().get("reason");
	             System.out.println(reason);
	             if (!reason.equals(ClientDisconnectionReason.MANUAL))
	             {
	                 if (reason.equals(ClientDisconnectionReason.IDLE))
	                     System.out.println("A disconnection occurred due to inactivity");
	                 else if (reason.equals(ClientDisconnectionReason.KICK))
	                     System.out.println("You have been kicked by the moderator");
	                 else if (reason.equals(ClientDisconnectionReason.BAN))
	                     System.out.println("You have been banned by the moderator");
	                 else
	                     System.out.println("A disconnection occurred due to unknown reason; please check the server log");
	             }
	             else
	             {
	                 // Manual disconnection is usually ignored
	             }
	         }
	     });
		smrtfx.addEventListener(SFSEvent.EXTENSION_RESPONSE, new IEventListener() {
			
			@Override
			public void dispatch(BaseEvent evnt) throws SFSException {
				// TODO Auto-generated method stub
				Map param=evnt.getArguments();
				
				System.out.println("getting response");
				
			}
		});
		
		ConfigData cfgdata=new ConfigData();
		cfgdata.setHost("192.168.9.84");
		cfgdata.setPort(9933);
		cfgdata.setZone("MyExtension");
		cfgdata.setUseBBox(true);
		
		smrtfx.connect(cfgdata);
		while(true){
		if(smrtfx.isConnected())
		{
		ISFSObject params = new SFSObject();
		 params.putInt("n1", 10);
		 params.putInt("n2", 37);
		 
		 smrtfx.send( new ExtensionRequest("math", params) );
		}
		}
		

	}
	
	public static void main(String[] args) {
		
		System.out.println("calling the smartfox server no argument constructor");
		new SmartFoxClient();
		
		
		
	}
	
}