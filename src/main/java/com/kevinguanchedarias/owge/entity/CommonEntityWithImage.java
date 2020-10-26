package com.kevinguanchedarias.owge.entity;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;

/**
 * Represents a CommonEntity that also has an image
 *
 * @deprecated Image should be managed by {@link ImageStore} , so use
 *             {@link CommonEntityWithImageStore}
 * @since 0.7.0
 * @author Kevin Guanche Darias <kevin@kevinguanchedarias.com>
 */
@Deprecated(since = "0.8.0")
@MappedSuperclass
public class CommonEntityWithImage<K extends Number> extends CommonEntity<K> {
	private static final long serialVersionUID = -3650030382618207233L;

	private String image;

	@Column(name = "image")
	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}
}
