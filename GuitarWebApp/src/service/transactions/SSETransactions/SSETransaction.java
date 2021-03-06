package service.transactions.SSETransactions;

import java.util.Map;

import service.sse.ServerSentEvent;
import service.sse.ServerSentEventBroadcaster;
import service.transactions.Transaction;

public abstract class SSETransaction implements Transaction{
	private ServerSentEventBroadcaster broadcaster = ServerSentEventBroadcaster.getInstance();
	private ServerSentEvent sse;
	
	@Override
	public Object execute(Map<String, Object> params) throws Exception {
		sse = initEvent(params);
		System.out.println("sse" + sse);
		broadcaster.broadcast(sse);
		return null;
	}
	
	public abstract ServerSentEvent initEvent(Map<String, Object> params) throws Exception;

}
