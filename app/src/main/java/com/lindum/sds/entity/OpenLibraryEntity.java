package com.lindum.sds.entity;

import androidx.annotation.NonNull;

/**
 * @author MarkGosling
 * @date 2022/4/11 16:06
 */

public class OpenLibraryEntity {
 String name;
 String content;
 String lisence;

 public String getName() {
  return name;
 }

 public void setName(String name) {
  this.name = name;
 }

 public String getContent() {
  return content;
 }

 public void setContent(String content) {
  this.content = content;
 }

 public String getLisence() {
  return lisence;
 }

 public void setLisence(String lisence) {
  this.lisence = lisence;
 }

 @NonNull
 @Override
 public String toString() {
  return "OpenLibraryEntity{" +
          "name='" + name + '\'' +
          ", content='" + content + '\'' +
          ", lisence='" + lisence + '\'' +
          '}';
 }
}
