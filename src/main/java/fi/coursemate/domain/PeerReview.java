package fi.coursemate.domain;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import com.fasterxml.jackson.annotation.JsonIgnore;

/**
 * Peer-review entity
 * 
 * @author h01270
 */
@Entity
@EntityListeners(AuditingEntityListener.class)
public class PeerReview {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)	
	private long reviewid;
    
    @ManyToOne
	@JoinColumn(name = "id")
	private Student student;

    @ManyToOne
	@JoinColumn(name = "courseid")
    private Course course;    
    
	@OneToMany(cascade = CascadeType.ALL)
    @JsonIgnore
	private List<Question> questions;	
	    
    private int grade;
    
    @Column(length = 1000)
    private String description;
	
	@CreatedDate
	private Date createdDate;	

	@CreatedBy
	private String createdBy;
	
    public PeerReview() {}
    
    public PeerReview(Student student, Course course) {
		super();
		this.student = student;
		this.course = course;
	}
	
	public long getReviewid() {
		return reviewid;
	}

	public void setReviewid(long reviewid) {
		this.reviewid = reviewid;
	}

	public Student getStudent() {
		return student;
	}
	
	public void setStudent(Student student) {
		this.student = student;
	}
		
	public Course getCourse() {
		return course;
	}

	public void setCourse(Course course) {
		this.course = course;
	}

	public int getGrade() {
		return grade;
	}
	
	public void setGrade(int grade) {
		this.grade = grade;
	}
	
	public String getDescription() {
		return description;
	}
	
	public void setDescription(String description) {
		this.description = description;
	}

	public Date getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}

	public String getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}

	public List<Question> getQuestions() {
		return questions;
	}

	public void setQuestions(List<Question> questions) {
		this.questions = questions;
	}
}
