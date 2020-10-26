/**
 *
 */
package com.kevinguanchedarias.owge.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 *
 * @since 0.8.0
 * @author Kevin Guanche Darias <kevin@kevinguanchedarias.com>
 */
@Entity
@Table(name = "admin_users")
public class AdminUser implements EntityWithId<Integer> {
	private static final long serialVersionUID = 7181807205260800042L;

	@Id
	private Integer id;

	@Column(nullable = false)
	private String username;

	@Column(nullable = false)
	private Boolean enabled;

	@Column(name = "can_add_admins", nullable = false)
	private Boolean canAddAdmins = false;

	/**
	 * @since 0.8.0
	 * @return the id
	 */
	@Override
	public Integer getId() {
		return id;
	}

	/**
	 * @since 0.8.0
	 * @param id the id to set
	 */
	@Override
	public void setId(Integer id) {
		this.id = id;
	}

	/**
	 * @since 0.8.0
	 * @return the username
	 */
	public String getUsername() {
		return username;
	}

	/**
	 * @since 0.8.0
	 * @param username the username to set
	 */
	public void setUsername(String username) {
		this.username = username;
	}

	/**
	 * @since 0.8.0
	 * @return the enabled
	 */
	public Boolean getEnabled() {
		return enabled;
	}

	/**
	 * @since 0.8.0
	 * @param enabled the enabled to set
	 */
	public void setEnabled(Boolean enabled) {
		this.enabled = enabled;
	}

	/**
	 * @return the canAddAdmins
	 * @since 0.9.0
	 * @author Kevin Guanche Darias <kevin@kevinguanchedarias.com>
	 */
	public Boolean getCanAddAdmins() {
		return canAddAdmins;
	}

	/**
	 * @param canAddAdmins the canAddAdmins to set
	 * @author Kevin Guanche Darias
	 * @since 0.9.0
	 */
	public void setCanAddAdmins(Boolean canAddAdmins) {
		this.canAddAdmins = canAddAdmins;
	}
}
