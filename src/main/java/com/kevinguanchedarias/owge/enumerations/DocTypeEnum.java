/**
 * 
 */
package com.kevinguanchedarias.owge.enumerations;

/**
 * Has the possible values for document type inside the Git docs
 * 
 * @since 0.8.0
 * @author Kevin Guanche Darias <kevin@kevinguanchedarias.com>
 */
public enum DocTypeEnum {
	EXCEPTIONS;

	private String customPath;

	private DocTypeEnum() {

	}

	/**
	 * Finds the path for the given enum type
	 * 
	 * @return
	 * @since 0.8.0
	 * @author Kevin Guanche Darias <kevin@kevinguanchedarias.com>
	 */
	public String findPath() {
		return customPath == null || customPath == "" ? name().toLowerCase() : customPath;
	}
}
