package com.kevinguanchedarias.owge.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "mission_types")
public class MissionType implements EntityWithId<Integer> {
	private static final long serialVersionUID = -4343475889445744756L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@Column(nullable = false, length = 50)
	private String code;

	@Column(nullable = false, length = 200)
	private String description;

	@Column(name = "is_shared", nullable = false)
	private Boolean isShared;

	@Override
	public Integer getId() {
		return id;
	}

	@Override
	public void setId(Integer id) {
		this.id = id;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Boolean getIsShared() {
		return isShared;
	}

	public void setIsShared(Boolean isShared) {
		this.isShared = isShared;
	}

}
