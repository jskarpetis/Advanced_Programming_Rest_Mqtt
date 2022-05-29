package gr.upatras.rest.mqtt;

import org.springframework.stereotype.Service;

@Service
public class MessageService implements IMessageService{
	
	int ix = 1000;

	@Override
	public Message addMessage(Message m) {
		// TODO Auto-generated method stub
		m.setId(++ix);
		new MyMqttClient().runClient(m);
		return m;
	}

}