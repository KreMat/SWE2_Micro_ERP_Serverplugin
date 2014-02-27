package at.technikum.wien.winterhalder.kreuzriegler.swe2.domain;

/**
 * 
 * @author Matthias
 * 
 */
public abstract class AbstractEntity {

	protected long id;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

}
