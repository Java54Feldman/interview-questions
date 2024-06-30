package telran.interviews;

import java.util.*;

//all methods should have O[1] complexity
public class ConnectionPool {
	// data Structure
	LinkedHashMap<Long, Connection> pool;
	int size;

	@SuppressWarnings("serial")
	public ConnectionPool(int size) {
		this.size = size;
		pool = new LinkedHashMap<Long, Connection>(10, 0.75f, true) {
			@Override
			protected boolean removeEldestEntry(Map.Entry<Long, Connection> entry) {
				return size() > ConnectionPool.this.size;
			}
		};
	}

	public Connection getConnection(Connection connection) {
		// returns a connection from the pool if it exists
		// otherwise creates new connection, adds in pool and returns new created
		// connections
		return pool.computeIfAbsent(connection.id(), k -> connection);
	}

	public boolean isInPool(long id) {
		// returns true if a given connection exists in the pool
		// otherwise returns false
		return pool.containsKey(id);
	}
}
