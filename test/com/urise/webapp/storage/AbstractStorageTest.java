package com.urise.webapp.storage;

import com.urise.webapp.exception.ExistStorageException;
import com.urise.webapp.exception.NotExistStorageException;
import com.urise.webapp.exception.StorageException;
import com.urise.webapp.model.Resume;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

public abstract class AbstractStorageTest {
    protected Storage storage;

    public AbstractStorageTest(Storage storage) {
        this.storage = storage;
    }

    private static final String UUID_1 = "uuid1";
    protected static final Resume RESUME_1 = new Resume(UUID_1, "name1");
    private static final String UUID_2 = "uuid2";
    protected static final Resume RESUME_2 = new Resume(UUID_2, "name2");
    private static final String UUID_3 = "uuid3";
    protected static final Resume RESUME_3 = new Resume(UUID_3, "name3");

    @Before
    public void setUp() {
        storage.clear();
        storage.save(RESUME_1);
        storage.save(RESUME_2);
        storage.save(RESUME_3);
    }

    @Test(expected = NotExistStorageException.class)
    public void getNotExist() {
        storage.get("uuid7");
    }

    @Test
    public void clear() {
        storage.clear();
        Assert.assertEquals(storage.size(), 0);
    }

    @Test
    public void save() {
        Resume r4 = new Resume("uuid4", "name4");
        storage.save(r4);
        assertGet(r4);
    }

    @Test(expected = ExistStorageException.class)
    public void saveExist() {
        storage.save(RESUME_2);
    }

    @Test
    public void get() {
        assertGet(RESUME_1);
        assertGet(RESUME_2);
        assertGet(RESUME_3);
    }

    @Test(expected = NotExistStorageException.class)
    public void deleteNotExist() {
        storage.delete("uuid7");
    }

    @Test(expected = NotExistStorageException.class)
    public void delete() {
        storage.delete("uuid1");
        storage.delete("uuid2");
        storage.delete("uuid3");
        assertGet(RESUME_1);
    }

    @Test
    public void update() {
        Resume updatedResumeR2 = new Resume("uuid2", "name2");
        storage.update(updatedResumeR2);
        assertGet(updatedResumeR2);
    }

    @Test(expected = NotExistStorageException.class)
    public void updateNotExist() {
        storage.update(new Resume("uuid7", "name7"));
    }

    @Test
    public void getAllSorted() {
        List<Resume> allResumes = storage.getAllSorted();
        Assert.assertEquals(3, allResumes.size());
        Assert.assertEquals(allResumes, Arrays.asList(RESUME_1, RESUME_2, RESUME_3));
    }

    private void assertGet(Resume resume) {
        Assert.assertEquals(resume, storage.get(resume.getUuid()));
    }
}

