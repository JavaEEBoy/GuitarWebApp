package model.representation;

import java.util.LinkedHashSet;
import java.util.Set;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import utils.AuthType;

@XmlRootElement
@XmlAccessorType(XmlAccessType.PROPERTY)
public class UserRepresentation{
	@XmlElement
	private String ID;
	@XmlElement
	private AuthType authType;
	@XmlElement
	private String avatarLink;
	@XmlElement
	private String gender;
	@XmlElement
	private String nickName;
	@XmlElement
	private String lookingFor;
	@XmlElement
	private String relationship;
	@XmlElement
	private String birthday;
	@XmlElement
	private Set<String> imageLinks;
	@XmlElement
	private Set<Long> collectedPosts;
	@XmlElement
	private Set<String> followeesID;
	@XmlElement
	private Set<String> followersID;
	@XmlElement
	private String campus;
	@XmlElement
	private String dorm;
	@XmlElement
	private String dormNum;
	
	public String getID() {
		return ID;
	}
	
	public void setID(String iD) {
		ID = iD;
	}

	public AuthType getAuthType() {
		return authType;
	}

	public void setAuthType(AuthType authType) {
		this.authType = authType;
	}

	public String getAvatarLink() {
		if(this.avatarLink==null)
			return "";
		return avatarLink;
	}

	public void setAvatarLink(String avatarLink) {
		this.avatarLink = avatarLink;
	}

	public String getGender() {
		if(this.gender==null)
			return "";
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getNickName() {
		if(this.nickName==null)
			return "";
		return nickName;
	}

	public void setNickName(String nickName) {
		this.nickName = nickName;
	}

	public String getLookingFor() {
		if(this.lookingFor==null)
			return "";
		return lookingFor;
	}

	public void setLookingFor(String lookingFor) {
		this.lookingFor = lookingFor;
	}

	public String getRelationship() {
		if(this.relationship==null)
			return "";
		return relationship;
	}

	public void setRelationship(String relationship) {
		this.relationship = relationship;
	}

	public String getBirthday() {
		if(this.birthday==null)
			return "";
		return birthday;
	}

	public void setBirthday(String birthday) {
		this.birthday = birthday;
	}

	public Set<String> getImageLinks() {
		if(imageLinks==null)
			return new LinkedHashSet<String>();
		return imageLinks;
	}

	public void setImageLinks(Set<String> imageLinks) {
		this.imageLinks = imageLinks;
	}

	public Set<String> getFolloweesID() {
		if(followeesID==null)
			return new LinkedHashSet<String>();
		return followeesID;
	}

	public void addFolloweeID(String followeeID) {
		if(followeesID==null)
			this.followeesID = new LinkedHashSet<String>();
		this.followeesID.add(followeeID);
	}

	public Set<String> getFollowersID() {
		if(followersID==null)
			return new LinkedHashSet<String>();
		return followersID;
	}

	public void addFollowerID(String followerID) {
		if(followersID==null)
			this.followersID = new LinkedHashSet<String>();
		this.followersID.add(followerID);
	}

	public Set<Long> getCollectedPosts() {
		if(collectedPosts==null)
			return new LinkedHashSet<Long>();
		return collectedPosts;
	}
	
	public void addCollectedPost(Long collectedPost) {
		if(this.collectedPosts == null){
			this.collectedPosts = new LinkedHashSet<Long>();
		}
		this.collectedPosts.add(collectedPost);
	}

	public String getCampus() {
		return campus;
	}

	public void setCampus(String campus) {
		this.campus = campus;
	}

	public String getDorm() {
		return dorm;
	}

	public void setDorm(String dorm) {
		this.dorm = dorm;
	}

	public String getDormNum() {
		return dormNum;
	}

	public void setDormNum(String dormNum) {
		this.dormNum = dormNum;
	}
	
}