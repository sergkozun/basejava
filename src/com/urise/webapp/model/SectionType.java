package com.urise.webapp.model;

public enum SectionType {
    PERSONAL("Личные качества"),
    OBJECTIVE("Позиция"),
    ACHIEVEMENT("Достижения"),
    QUALIFICATIONS("Квалификация"),
    EXPERIENCE("Опыт работы"),
    EDUCATION("Образование");

    private String title;

    public String getTitle() {
        return title;
    }

    SectionType(String title){
        this.title = title;
    }
}
