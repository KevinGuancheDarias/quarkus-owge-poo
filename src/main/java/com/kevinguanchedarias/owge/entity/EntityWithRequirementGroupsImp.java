package com.kevinguanchedarias.owge.entity;

import java.util.List;

import javax.persistence.MappedSuperclass;
import javax.persistence.Transient;

/**
 * Represents an entity that has group requirements
 *
 * @since 0.9.0
 * @author Kevin Guanche Darias <kevin@kevinguanchedarias.com>
 *
 */
@MappedSuperclass
public abstract class EntityWithRequirementGroupsImp extends EntityWithRelationImp
		implements EntityWithRequirementGroups {
	private static final long serialVersionUID = 4944661673529201151L;

	@Transient
	private List<RequirementGroup> requirementGroups;

	/**
	 * @return the requirementGroups
	 * @since 0.9.0
	 * @author Kevin Guanche Darias <kevin@kevinguanchedarias.com>
	 */
	@Override
	public List<RequirementGroup> getRequirementGroups() {
		return requirementGroups;
	}

	/**
	 * @param requirementGroups the requirementGroups to set
	 * @author Kevin Guanche Darias
	 * @since 0.9.0
	 */
	@Override
	public void setRequirementGroups(List<RequirementGroup> requirementGroups) {
		this.requirementGroups = requirementGroups;
	}

}
