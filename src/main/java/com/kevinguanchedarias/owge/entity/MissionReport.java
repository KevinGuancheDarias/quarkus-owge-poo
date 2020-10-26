package com.kevinguanchedarias.owge.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table(name = "mission_reports")
public class MissionReport implements EntityWithId<Long> {
	private static final long serialVersionUID = 129057515438080621L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "json_body", nullable = false)
	private String jsonBody;

	@Transient
	private Mission relatedMission;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "user_id", nullable = false)
	private UserStorage user;

	@Column(name = "report_date")
	private Date reportDate;

	@Column(name = "user_read_date")
	private Date userReadDate;

	@Column(name = "is_enemy")
	private Boolean isEnemy = false;

	public MissionReport() {

	}

	public MissionReport(String jsonBody, Mission relatedMission) {
		this.jsonBody = jsonBody;
		this.relatedMission = relatedMission;
	}

	@Override
	public Long getId() {
		return id;
	}

	public String getJsonBody() {
		return jsonBody;
	}

	public void setJsonBody(String jsonBody) {
		this.jsonBody = jsonBody;
	}

	public Mission getRelatedMission() {
		return relatedMission;
	}

	public void setRelatedMission(Mission relatedMission) {
		this.relatedMission = relatedMission;
	}

	public UserStorage getUser() {
		return user;
	}

	public void setUser(UserStorage user) {
		this.user = user;
	}

	public Date getReportDate() {
		return reportDate;
	}

	public void setReportDate(Date reportDate) {
		this.reportDate = reportDate;
	}

	public Date getUserReadDate() {
		return userReadDate;
	}

	public void setUserReadDate(Date userReadDate) {
		this.userReadDate = userReadDate;
	}

	@Override
	public void setId(Long id) {
		this.id = id;
	}

	/**
	 * @return the isEnemy
	 * @since 0.9.0
	 * @author Kevin Guanche Darias <kevin@kevinguanchedarias.com>
	 */
	public Boolean getIsEnemy() {
		return Boolean.TRUE.equals(isEnemy);
	}

	/**
	 * @param isEnemy the isEnemy to set
	 * @author Kevin Guanche Darias
	 * @since 0.9.0
	 */
	public void setIsEnemy(Boolean isEnemy) {
		this.isEnemy = isEnemy;
	}
}
