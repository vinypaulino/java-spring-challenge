package com.vinypaulino.challenge.ubs.domain.model;
import java.lang.reflect.Constructor;
import java.util.ArrayList;
import java.util.List;

public class PaginationResult<T> {

	private ResultSetMetadata resultSetMetadata;
	private List<T> results;
	
	public PaginationResult() {
		this.results = new ArrayList<T>();
	}
	


	public List<T> getResults() {
		return results;
	}

	public void setResults(List<T> results) {
		this.results = results;
	}

	public ResultSetMetadata getResultSetMetadata() {
		return resultSetMetadata;
	}

	public void setResultSetMetadata(ResultSetMetadata resultSetMetadata) {
		this.resultSetMetadata = resultSetMetadata;
	}

	public static class ResultSetMetadata {
		private long count;
		private int offset;
		private int limit;

		public ResultSetMetadata() {

		}

	

	

		public ResultSetMetadata(long count, int offset, int limit) {
			this.count = count;
			this.offset = offset;
			this.limit = limit;
		}

		public ResultSetMetadata(ResultSetMetadata resultSetMetadata) {
			this.count = resultSetMetadata.count;
			this.offset = resultSetMetadata.offset;
			this.limit = resultSetMetadata.limit;
		}

		public long getCount() {
			return count;
		}

		public ResultSetMetadata setCount(long count) {
			this.count = count;
			return this;
		}

		public int getOffset() {
			return offset;
		}

		public ResultSetMetadata setOffset(int offset) {
			this.offset = offset;
			return this;
		}

		public int getLimit() {
			return limit;
		}

		public ResultSetMetadata setLimit(int limit) {
			this.limit = limit;
			return this;
		}

		public boolean isTheSameAs(ResultSetMetadata other) {
			return this.count == other.count && this.limit == other.limit && this.offset == other.offset;
		}
	}

	public <K> PaginationResult<K> parsePaginationResultEntityTo(Class<K> clazz) {
		PaginationResult<K> paginationResult = new PaginationResult<K>();
		paginationResult.resultSetMetadata = new ResultSetMetadata(this.resultSetMetadata);

		if (this.getResults().isEmpty()) {
			return paginationResult;
		}

		try {
			Constructor<K> constructor = clazz.getConstructor(this.results.get(0).getClass());
			for (T t : results) {
				paginationResult.results.add(constructor.newInstance(t));
			}
			return paginationResult;

		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException(e.getMessage());
		}
	}
	

}
