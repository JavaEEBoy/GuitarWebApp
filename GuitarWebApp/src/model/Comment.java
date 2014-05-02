package model;

import java.util.Set;

import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Transient;
import javax.persistence.Version;

import utils.CommentType;

@Entity
@Access(AccessType.FIELD)
public class Comment {
	@Id @GeneratedValue(strategy=GenerationType.SEQUENCE)
	private Long ID;
	@Version
	private Integer version;
	
	private String content;
	@Transient
	private CommentType type;
	
	@Transient
	private Supportable supportable;
	
	@OneToOne
	private User owner;
	
	public Comment(){
		supportable = new Unsupportable();
	}
	
	public Comment(String content,CommentType commentTypes){
		this.content = content;
		this.type = commentTypes;
	}
	
	public Long getID(){
		return this.ID;
	}
	
	public String getContent(){
		return content;
	}
	
	@Access(AccessType.PROPERTY)
	@Enumerated(EnumType.STRING)
	public CommentType getType(){
		return type;
	}
	
	public void setType(CommentType type){
		if(type.equals(CommentType.ANSWER))
			supportable = new SupportableImp();
		this.type = type;
	}
	
	public User getOwner() {
		return owner;
	}
	
	public void setOwner(User owner) {
		this.owner = owner;
	}
	
	public void setSupportable(Supportable supportable){
		this.supportable = supportable;
	}
	
	public void support(User user){
		supportable.clickSupport(user);
	}
	
	public void cancelSupport(User user){
		supportable.cancelSupport(user);
	}
	
	public boolean isSupportable(){
		return supportable.isSupportable();
	}
	
	public int getSupportNum(){
		return supportable.getSupportNum();
	}
	
	@Access(AccessType.PROPERTY)
	@OneToMany(fetch=FetchType.LAZY,cascade=CascadeType.MERGE)
	@JoinTable(name="COMMENT_SUPPORTORS",
	joinColumns=@JoinColumn(name="COMMENT_ID"),
	inverseJoinColumns=@JoinColumn(name="SUPPORTOR_ID"))
	public Set<User> getSupportors(){
		return supportable.getSupportors();
	}
	
	public void setSupportors(Set<User> supportors){
		supportable.setSupportors(supportors);
	}
	
	public void delete(){
		owner = null;
		supportable.delete();
	}
	
	@Override
	public boolean equals(Object o){
		if(o instanceof Comment){
			Comment other = (Comment) o;
			if(other.getID()!=null&&this.ID!=null){
				if(other.getID().equals(this.ID))
					return true;
			} else if(other.getID()==null&&this.ID==null){
				return super.equals(other);
			} else{
				return false;
			}
		}
		
		return false;
	}
}
