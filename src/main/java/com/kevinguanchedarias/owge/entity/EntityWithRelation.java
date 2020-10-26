package com.kevinguanchedarias.owge.entity;

import com.kevinguanchedarias.owge.enumerations.ObjectEnum;

/**
 *
 * @since 0.9.0
 * @author Kevin Guanche Darias <kevin@kevinguanchedarias.com>
 *
 */
public interface EntityWithRelation extends EntityWithId<Integer> {
	/**
	 *
	 * @return
	 * @since 0.9.0
	 * @author Kevin Guanche Darias <kevin@kevinguanchedarias.com>
	 */
	public ObjectEnum getObject();

	/**
	 *
	 * @return
	 * @since 0.9.0
	 * @author Kevin Guanche Darias <kevin@kevinguanchedarias.com>
	 */
	public ObjectRelation getRelation();

	/**
	 *
	 * @param relation
	 * @since 0.9.0
	 * @author Kevin Guanche Darias <kevin@kevinguanchedarias.com>
	 */
	public void setRelation(ObjectRelation relation);
}
