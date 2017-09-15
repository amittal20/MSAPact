package com.niit.msa.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="itemreview")
public class ItemReview {

	@Id
	private long id;
	
	
	private long itemid;
	
	private String message;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public long getItemid() {
		return itemid;
	}

	public void setItemid(long itemid) {
		this.itemid = itemid;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public ItemReview(long id, long itemid, String message) {
		super();
		this.id = id;
		this.itemid = itemid;
		this.message = message;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (int) (id ^ (id >>> 32));
		result = prime * result + (int) (itemid ^ (itemid >>> 32));
		result = prime * result + ((message == null) ? 0 : message.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ItemReview other = (ItemReview) obj;
		if (id != other.id)
			return false;
		if (itemid != other.itemid)
			return false;
		if (message == null) {
			if (other.message != null)
				return false;
		} else if (!message.equals(other.message))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "ItemReview [id=" + id + ", itemid=" + itemid + ", message=" + message + "]";
	}

	public ItemReview() {
		super();
	}
	
	
}
