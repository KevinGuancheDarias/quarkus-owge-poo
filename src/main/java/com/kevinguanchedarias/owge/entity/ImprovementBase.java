package com.kevinguanchedarias.owge.entity;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

@MappedSuperclass
public abstract class ImprovementBase<K> implements EntityWithId<K> {
	private static final long serialVersionUID = 8483043984040996933L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private K id;

	/**
	 * @deprecated Unused property, the system uses now an UnitType requirement of
	 *             type AMOUNT
	 */
	@Deprecated
	@Column(name = "more_soldiers_production")
	private Float moreSoldiersProduction = 0.0F;

	@Column(name = "more_primary_resource_production")
	private Float morePrimaryResourceProduction = 0.0F;

	@Column(name = "more_secondary_resource_production")
	private Float moreSecondaryResourceProduction = 0.0F;

	@Column(name = "more_energy_production")
	private Float moreEnergyProduction = 0.0F;

	@Column(name = "more_charge_capacity")
	private Float moreChargeCapacity = 0.0F;

	@Column(name = "more_missions_value")
	private Float moreMisions = 0.0F;

	@Column(name = "more_upgrade_research_speed")
	private Float moreUpgradeResearchSpeed = 0F;

	@Column(name = "more_unit_build_speed")
	private Float moreUnitBuildSpeed = 0F;

	@Override
	public K getId() {
		return id;
	}

	@Override
	public void setId(K id) {
		this.id = id;
	}

	/**
	 * @deprecated Unused property, the system uses now an UnitType requirement of
	 *             type AMOUNT
	 * 
	 * @param value
	 * @author Kevin Guanche Darias <kevin@kevinguanchedarias.com>
	 */
	@Deprecated
	public void addMoreSoldiersProduction(Float value) {
		moreSoldiersProduction += value;
	}

	public ImprovementBase<K> addMorePrimaryResourceProduction(Float value) {
		morePrimaryResourceProduction += value;
		return this;
	}

	public ImprovementBase<K> addMoreSecondaryResourceProduction(Float value) {
		moreSecondaryResourceProduction += value;
		return this;
	}

	public ImprovementBase<K> addMoreEnergyProduction(Float value) {
		moreEnergyProduction += value;
		return this;
	}

	public ImprovementBase<K> addMoreChargeCapacity(Float value) {
		moreChargeCapacity += value;
		return this;
	}

	public ImprovementBase<K> addMoreMissions(Float value) {
		moreMisions += value;
		return this;
	}

	public ImprovementBase<K> addMoreUpgradeResearchSpeed(Float value) {
		moreUpgradeResearchSpeed += value;
		return this;
	}

	public ImprovementBase<K> addMoreUnitBuildSpeed(Float value) {
		moreUnitBuildSpeed += value;
		return this;
	}

	/**
	 * 
	 * @deprecated Use {@link ImprovementBo#findAsRational(Double)}, as we may reuse
	 *             this for other improvements
	 * @return
	 * @author Kevin Guanche Darias <kevin@kevinguanchedarias.com>
	 */
	@Deprecated(since = "0.8.0")
	public Double findRationalChargeCapacity() {
		return moreChargeCapacity / (double) 100;
	}

	/**
	 * @deprecated Unused property, the system uses now an UnitType requirement of
	 *             type AMOUNT
	 * @return
	 * @author Kevin Guanche Darias <kevin@kevinguanchedarias.com>
	 */
	@Deprecated
	public Float getMoreSoldiersProduction() {
		return moreSoldiersProduction;
	}

	/**
	 * @deprecated Unused property, the system uses now an UnitType requirement of
	 *             type AMOUNT
	 * @param moreSoldiersProduction
	 * @author Kevin Guanche Darias <kevin@kevinguanchedarias.com>
	 */
	@Deprecated
	public void setMoreSoldiersProduction(Float moreSoldiersProduction) {
		this.moreSoldiersProduction = moreSoldiersProduction;
	}

	public Float getMorePrimaryResourceProduction() {
		return morePrimaryResourceProduction;
	}

	public void setMorePrimaryResourceProduction(Float morePrimaryResourceProduction) {
		this.morePrimaryResourceProduction = morePrimaryResourceProduction;
	}

	public Float getMoreSecondaryResourceProduction() {
		return moreSecondaryResourceProduction;
	}

	public void setMoreSecondaryResourceProduction(Float moreSecondaryResourceProduction) {
		this.moreSecondaryResourceProduction = moreSecondaryResourceProduction;
	}

	public Float getMoreEnergyProduction() {
		return moreEnergyProduction;
	}

	public void setMoreEnergyProduction(Float moreEnergyProduction) {
		this.moreEnergyProduction = moreEnergyProduction;
	}

	public Float getMoreChargeCapacity() {
		return moreChargeCapacity;
	}

	public void setMoreChargeCapacity(Float moreChargeCapacity) {
		this.moreChargeCapacity = moreChargeCapacity;
	}

	public Float getMoreMisions() {
		return moreMisions;
	}

	public void setMoreMisions(Float moreMisions) {
		this.moreMisions = moreMisions;
	}

	public Float getMoreUpgradeResearchSpeed() {
		return moreUpgradeResearchSpeed != null ? moreUpgradeResearchSpeed : 0F;
	}

	public void setMoreUpgradeResearchSpeed(Float moreUpgradeResearchSpeed) {
		this.moreUpgradeResearchSpeed = moreUpgradeResearchSpeed;
	}

	public Float getMoreUnitBuildSpeed() {
		return moreUnitBuildSpeed != null ? moreUnitBuildSpeed : moreUnitBuildSpeed;
	}

	public void setMoreUnitBuildSpeed(Float moreUnitBuildSpeed) {
		this.moreUnitBuildSpeed = moreUnitBuildSpeed;
	}

}
