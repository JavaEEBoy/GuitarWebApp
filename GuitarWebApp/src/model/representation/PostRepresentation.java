package model.representation;

import java.util.LinkedHashSet;
import java.util.Set;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import model.Comment;
import model.User;
import utils.PostType;

@XmlRootElement
@XmlAccessorType(XmlAccessType.PROPERTY)
public class PostRepresentation {
	@XmlElement
	private Long ID;
	@XmlElement
	private Set<String> mediaLocation;
	@XmlElement
	private String topic;
	@XmlElement
	private String content;
	@XmlElement
	private PostType type;
	@XmlElement
	private String publishDate;
	@XmlElement
	private boolean active;

	@XmlElement
	private Set<CommentRepresentation> commentRepresentations;
	@XmlElement
	private UserRepresentation ownerRepresentation;
	@XmlElement
	private Set<UserRepresentation> likerRepresentations;
	@XmlElement
	private Set<UserRepresentation> collectorRepresentations;
	@XmlElement
	private String startDate;
	@XmlElement
	private Set<UserRepresentation> participantRepresentations;
	@XmlElement
	private String information;
	
	public Long getID() {
		return ID;
	}

	public void setID(Long iD) {
		ID = iD;
	}

	public Set<String> getMediaLocation() {
		if (mediaLocation == null)
			return new LinkedHashSet<String>();
		return mediaLocation;
	}

	public void setMediaLocation(Set<String> mediaLocation) {
		this.mediaLocation = mediaLocation;
	}

	public String getTopic() {
		return topic;
	}

	public void setTopic(String topic) {
		this.topic = topic;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public PostType getType() {
		return type;
	}

	public void setType(PostType type) {
		this.type = type;
	}

	public String getPublishDate() {
		return publishDate;
	}

	public void setPublishDate(String publishDate) {
		this.publishDate = publishDate;
	}

	public boolean isActive() {
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}

	public Set<CommentRepresentation> getCommentRepresentations() {
		if (commentRepresentations == null)
			return new LinkedHashSet<CommentRepresentation>();
		return commentRepresentations;
	}

	public void addCommentRepresentations(Set<Comment> comments) {
		if (this.commentRepresentations == null) {
			this.commentRepresentations = new LinkedHashSet<CommentRepresentation>();
		}
		for (Comment comment : comments) {
			this.commentRepresentations.add(comment.getRepresentation());
		}
	}

	public UserRepresentation getOwnerRepresentation() {
		return ownerRepresentation;
	}

	public void setOwner(UserRepresentation ownerRepresentation) {
		this.ownerRepresentation = ownerRepresentation;
	}

	public Set<UserRepresentation> getLikerRepresentations() {
		if (likerRepresentations == null)
			return new LinkedHashSet<UserRepresentation>();
		return likerRepresentations;
	}

	public void addLikerRepresentation(Set<User> likers) {
		if (this.likerRepresentations == null) {
			this.likerRepresentations = new LinkedHashSet<UserRepresentation>();
		}
		for (User liker : likers) {
			this.likerRepresentations.add(liker.getRepresentation());
		}
	}

	public Set<UserRepresentation> getCollectorRepresentations() {
		if(collectorRepresentations == null)
			return new LinkedHashSet<UserRepresentation>();
		return collectorRepresentations;
	}
	public void addCollectorRepresentation(Set<User> collectors) {
		if(this.collectorRepresentations == null) {
			this.collectorRepresentations = new LinkedHashSet<UserRepresentation>();
		}
		for (User collector : collectors) {
			this.collectorRepresentations.add(collector.getRepresentation());
		}
	}
	

	public String getStartDate() {
		if (this.startDate == null)
			return "";
		return startDate;
	}

	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}

	public Set<UserRepresentation> getParticipantRepresentations() {
		if (participantRepresentations == null)
			return new LinkedHashSet<UserRepresentation>();
		return participantRepresentations;
	}

	public void addParticipantRepresentations(Set<User> participants) {
		if (this.participantRepresentations == null) {
			this.participantRepresentations = new LinkedHashSet<UserRepresentation>();
		}
		for (User participant : participants) {
			this.participantRepresentations
					.add(participant.getRepresentation());
		}
	}

	public String getInformation() {
		if(this.information==null)
			return "";
		return information;
	}

	public void setInformation(String information) {
		this.information = information;
	}

}
