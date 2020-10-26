package com.kevinguanchedarias.owge.entity;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

@Entity
@Table(name = "user_storage")
public class UserStorage implements EntityWithId<Integer> {
	private static final long serialVersionUID = 3718075595543259580L;

	@Id
	private Integer id;

	private String username;
	private String email;

	@OneToOne
	@JoinColumn(name = "faction", nullable = false)
	@Fetch(FetchMode.JOIN)
	private Faction faction;

	@Column(name = "last_action")
	private Date lastAction;

	@OneToOne
	@JoinColumn(name = "home_planet", nullable = false)
	@Fetch(FetchMode.JOIN)
	private Planet homePlanet;

	@Column(name = "primary_resource")
	private Double primaryResource;

	@Column(name = "secondary_resource")
	private Double secondaryResource;

	@Column(nullable = false)
	private Double energy;

	@Column(name = "primary_resource_generation_per_second", nullable = true)
	@Deprecated(since = "0.8.0")
	private Double primaryResourceGenerationPerSecond = 0D;

	@Column(name = "secondary_resource_generation_per_second", nullable = true)
	@Deprecated(since = "0.8.0")
	private Double secondaryResourceGenerationPerSecond = 0D;

	@Column(name = "has_skipped_tutorial")
	private Boolean hasSkippedTutorial = false;
	/**
	 * @deprecated Max Energy is now a computed value
	 */
	@Deprecated(since = "0.7.0")
	@Column(name = "max_energy")
	private Double maxEnergy;

	@Column(nullable = false)
	private Double points = 0D;

	@OneToMany(mappedBy = "user", fetch = FetchType.LAZY)
	private List<UnlockedRelation> unlockedRelations;

	@Deprecated(since = "0.8.0")
	@OneToOne(mappedBy = "user", cascade = CascadeType.ALL, optional = true)
	@Fetch(FetchMode.JOIN)
	private UserImprovement improvements;

	@OneToMany(mappedBy = "user", fetch = FetchType.LAZY)
	private List<Mission> missions;

	@ManyToOne(fetch = FetchType.LAZY, optional = true)
	@JoinColumn(name = "alliance_id")
	@Fetch(FetchMode.JOIN)
	private Alliance alliance;

	@Column(name = "can_alter_twitch_state", nullable = false)
	private Boolean canAlterTwitchState = false;

	@Transient
	@Deprecated(since = "0.8.0")
	private Double computedPrimaryResourceGenerationPerSecond;

	@Transient
	@Deprecated(since = "0.8.0")
	private Double computedSecondaryResourceGenerationPerSecond;

	public void addtoPrimary(Double value) {
		primaryResource += value;
	}

	public void addToSecondary(Double value) {
		secondaryResource += value;
	}

	/**
	 * Fills the transient properties of the entity <br />
	 * <b>IMPORTANT: The entity should have all the "details" </b>
	 *
	 * @deprecated Transient properties of UserStorage are not longer required, use
	 *             version without transient argument
	 * @author Kevin Guanche Darias
	 */
	@Deprecated(since = "0.8.0")
	public void fillTransientValues() {
		if (faction != null) {
			computedPrimaryResourceGenerationPerSecond = (double) (faction.getPrimaryResourceProduction()
					+ (faction.getPrimaryResourceProduction()
							* (improvements.getMorePrimaryResourceProduction() / 100)));
			computedSecondaryResourceGenerationPerSecond = (double) (faction.getSecondaryResourceProduction()
					+ (faction.getSecondaryResourceProduction()
							* (improvements.getMoreSecondaryResourceProduction() / 100)));
		} else {
			computedPrimaryResourceGenerationPerSecond = 0D;
			computedSecondaryResourceGenerationPerSecond = 0D;
		}
	}

	/**
	 * Returns a new instance of {@link UserStorage} with only id and username <br>
	 * Potentially useful when wanting to remove ORM proxies
	 *
	 * @return
	 * @author Kevin Guanche Darias <kevin@kevinguanchedarias.com>
	 */
	public UserStorage toBasicInformation() {
		UserStorage retVal = new UserStorage();
		retVal.setId(id);
		retVal.setUsername(username);
		return retVal;
	}

	@Override
	public Integer getId() {
		return id;
	}

	@Override
	public void setId(Integer id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Faction getFaction() {
		return faction;
	}

	public void setFaction(Faction faction) {
		this.faction = faction;
	}

	public Date getLastAction() {
		return lastAction;
	}

	public void setLastAction(Date lastAction) {
		this.lastAction = lastAction;
	}

	public Planet getHomePlanet() {
		return homePlanet;
	}

	public void setHomePlanet(Planet homePlanet) {
		this.homePlanet = homePlanet;
	}

	public Double getPrimaryResource() {
		return primaryResource;
	}

	public void setPrimaryResource(Double primaryResource) {
		this.primaryResource = primaryResource;
	}

	public Double getSecondaryResource() {
		return secondaryResource;
	}

	public void setSecondaryResource(Double secondaryResource) {
		this.secondaryResource = secondaryResource;
	}

	public Double getEnergy() {
		return energy;
	}

	public void setEnergy(Double energy) {
		this.energy = energy;
	}

	/**
	 *
	 * @deprecated Not used, it's a calculated value by UserStorage
	 * @return
	 * @author Kevin Guanche Darias <kevin@kevinguanchedarias.com>
	 */
	@Deprecated(since = "0.8.0")
	public Double getPrimaryResourceGenerationPerSecond() {
		return primaryResourceGenerationPerSecond;
	}

	/**
	 *
	 * @deprecated Not used, it's a calculated value by UserStorage
	 * @author Kevin Guanche Darias <kevin@kevinguanchedarias.com>
	 */
	@Deprecated(since = "0.8.0")
	public void setPrimaryResourceGenerationPerSecond(Double primaryResourceGenerationPerSecond) {
		this.primaryResourceGenerationPerSecond = primaryResourceGenerationPerSecond;
	}

	/**
	 *
	 * @deprecated Not used, it's a calculated value by UserStorage
	 * @return
	 * @author Kevin Guanche Darias <kevin@kevinguanchedarias.com>
	 */
	@Deprecated(since = "0.8.0")
	public Double getSecondaryResourceGenerationPerSecond() {
		return secondaryResourceGenerationPerSecond;
	}

	/**
	 *
	 * @deprecated Not used, it's a calculated value by UserStorage
	 * @author Kevin Guanche Darias <kevin@kevinguanchedarias.com>
	 */
	@Deprecated(since = "0.8.0")
	public void setSecondaryResourceGenerationPerSecond(Double secondaryResourceGenerationPerSecond) {
		this.secondaryResourceGenerationPerSecond = secondaryResourceGenerationPerSecond;
	}

	/**
	 * @deprecated Max Energy is now a computed value
	 */
	@Deprecated
	public Double getMaxEnergy() {
		return maxEnergy;
	}

	/**
	 * @deprecated Max Energy is now a computed value
	 */
	@Deprecated
	public void setMaxEnergy(Double maxEnergy) {
		this.maxEnergy = maxEnergy;
	}

	/**
	 * @return the hasSkippedTutorial
	 * @since 0.9.0
	 * @author Kevin Guanche Darias <kevin@kevinguanchedarias.com>
	 */
	public Boolean getHasSkippedTutorial() {
		return hasSkippedTutorial;
	}

	/**
	 * @param hasSkippedTutorial the hasSkippedTutorial to set
	 * @author Kevin Guanche Darias
	 * @since 0.9.0
	 */
	public void setHasSkippedTutorial(Boolean hasSkippedTutorial) {
		this.hasSkippedTutorial = hasSkippedTutorial;
	}

	public Double getPoints() {
		return points;
	}

	public void setPoints(Double points) {
		this.points = points;
	}

	public List<UnlockedRelation> getUnlockedRelations() {
		return unlockedRelations;
	}

	public void setUnlockedRelations(List<UnlockedRelation> unlockedRelations) {
		this.unlockedRelations = unlockedRelations;
	}

	/**
	 *
	 * @deprecated We use computed improvements
	 * @return
	 * @author Kevin Guanche Darias <kevin@kevinguanchedarias.com>
	 */
	@Deprecated(since = "0.8.0")
	public UserImprovement getImprovements() {
		return improvements;
	}

	/**
	 * @deprecated We use computed improvements
	 * @param improvements
	 * @author Kevin Guanche Darias <kevin@kevinguanchedarias.com>
	 */
	@Deprecated(since = "0.8.0")
	public void setImprovements(UserImprovement improvements) {
		this.improvements = improvements;
	}

	public List<Mission> getMissions() {
		return missions;
	}

	public void setMissions(List<Mission> missions) {
		this.missions = missions;
	}

	/**
	 * @since 0.7.0
	 * @return the alliance
	 */
	public Alliance getAlliance() {
		return alliance;
	}

	/**
	 * @since 0.7.0
	 * @param alliance the alliance to set
	 */
	public void setAlliance(Alliance alliance) {
		this.alliance = alliance;
	}

	/**
	 * @return the canAlterTwitchState
	 * @since 0.9.5
	 * @author Kevin Guanche Darias <kevin@kevinguanchedarias.com>
	 */
	public Boolean getCanAlterTwitchState() {
		return canAlterTwitchState;
	}

	/**
	 * @param canAlterTwitchState the canAlterTwitchState to set
	 * @author Kevin Guanche Darias
	 * @since 0.9.5
	 */
	public void setCanAlterTwitchState(Boolean canAlterTwitchState) {
		this.canAlterTwitchState = canAlterTwitchState;
	}

	/**
	 *
	 * @deprecated Transient properties of UserStorage are not longer required, we
	 *             calculate in the frontend and in the backend
	 * @return
	 * @author Kevin Guanche Darias <kevin@kevinguanchedarias.com>
	 */
	@Deprecated(since = "0.8.0")
	public Double getComputedPrimaryResourceGenerationPerSecond() {
		return computedPrimaryResourceGenerationPerSecond;
	}

	/**
	 * @deprecated Transient properties of UserStorage are not longer required, we
	 *             calculate in the frontend and in the backend
	 * @return
	 * @author Kevin Guanche Darias <kevin@kevinguanchedarias.com>
	 */
	@Deprecated(since = "0.8.0")
	public Double getComputedSecondaryResourceGenerationPerSecond() {
		return computedSecondaryResourceGenerationPerSecond;
	}

}
