package com.jfb.hruser.entities;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "tb_role")
public class Role implements Serializable {
  private static final long serialVersionUID = 1L;

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  private String roleName;

  public Role() {
  }

  public Role(Long id, String roleName) {
    this.id = id;
    this.roleName = roleName;
  }

  public Long getId() {
    return this.id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getRoleName() {
    return this.roleName;
  }

  public void setRoleName(String roleName) {
    this.roleName = roleName;
  }

  @Override
  public boolean equals(Object o) {
    if (o == this)
      return true;
    if (!(o instanceof Role)) {
      return false;
    }
    Role role = (Role) o;
    return Objects.equals(roleName, role.roleName);
  }

  @Override
  public int hashCode() {
    return Objects.hashCode(roleName);
  }

}
