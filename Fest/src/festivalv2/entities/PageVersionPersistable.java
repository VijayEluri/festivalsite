package festivalv2.entities;
import java.util.Date;

import javax.jdo.annotations.IdGeneratorStrategy;
import javax.jdo.annotations.IdentityType;
import javax.jdo.annotations.PersistenceCapable;
import javax.jdo.annotations.Persistent;
import javax.jdo.annotations.PrimaryKey;

import com.google.appengine.api.datastore.Text;

@PersistenceCapable(identityType = IdentityType.APPLICATION)
public class PageVersionPersistable  {

	private static final long serialVersionUID = 1L;

	@PrimaryKey
	@Persistent(valueStrategy = IdGeneratorStrategy.IDENTITY)
	private Long id;
	
	@Persistent
	private Text content = new Text("");
	@Persistent
	private String pageName = "index";
	@Persistent
	private Date createdAt;
	


	public String getContent() {
		return content.getValue();
	}

	public void setContent(String content) {
		this.content = new Text(content);
	}

	public String getPageName() {
		return pageName;
	}

	public void setPageName(String pageName) {
		this.pageName = pageName;
	}

	public Date getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}

	public long getId() {
		if (id == null){
			return 0;
		}
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	@Override
	public String toString() {
		StringBuffer sb = new StringBuffer("PVP:");
		sb.append(id).append(":").append(pageName).append(":").append(createdAt).append(":").append(content);
		return sb.toString();
	}

	
	
	
}
