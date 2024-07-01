package telran.interviews;

import java.util.*;

//all methods should have O[1] complexity
public class ConnectionPool {
	// data Structure
	private LinkedHashMap<Long, Connection> pool;
	int size;

	@SuppressWarnings("serial")
	public ConnectionPool(int size) {
		pool = new LinkedHashMap<>(16, 0.75f, true) {
			@Override
			protected boolean removeEldestEntry(Map.Entry<Long, Connection> entry) {
				return size() > size;
			}
		};
	}

	public Connection getConnection(Connection connection) {
		// returns a connection from the pool if it exists
		// otherwise creates new connection, adds in pool and returns new created
		// connections
		long id = connection.id();
		return pool.computeIfAbsent(id, k -> new Connection(id));
	}

	public boolean isInPool(long id) {
		// returns true if a given connection exists in the pool
		// otherwise returns false
		return pool.containsKey(id);
	}
}
