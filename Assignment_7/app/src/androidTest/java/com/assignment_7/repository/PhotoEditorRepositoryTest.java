package com.assignment_7.repository;

import android.test.AndroidTestCase;

import com.assignment_7.domain.PhotoEditor;
import com.assignment_7.repositories.repository.PhotoEditorRepository;
import com.assignment_7.repositories.repositoryImplem.PhotoEditorRepositoryImplem;

import junit.framework.Assert;

import java.util.Set;

/**
 *Created by Phinda Encore Tomson on 4/21/2016.
 */
public class PhotoEditorRepositoryTest extends AndroidTestCase {
    private static final String TAG="PHOTO EDITOR TEST";
    private Long id;

    public void testCreateReadUpdateDelete() throws Exception{
        PhotoEditorRepository pEditorRepo=new PhotoEditorRepositoryImplem(this.getContext());
        PhotoEditor createEntity=new PhotoEditor.Builder()
                .first("Encore")
                .last("Tomson")
                .build();

        PhotoEditor insertedEntity=pEditorRepo.save(createEntity);
        id=insertedEntity.getId();
        Assert.assertNotNull(TAG + " CREATE ", insertedEntity);

        Set<PhotoEditor> pEditor=pEditorRepo.findAll();
        Assert.assertTrue(TAG + " READ ALL ", pEditor.size() > 0);

        PhotoEditor entity=pEditorRepo.findById(id);
        Assert.assertNotNull(TAG + " READ ENTITY ", entity);

        PhotoEditor updateEntity=new PhotoEditor.Builder()
                .copy(entity)
                .first("Encore")
                .last("Tomson")
                .build();
        pEditorRepo.update(updateEntity);
        PhotoEditor newEntity=pEditorRepo.findById(id);
        Assert.assertEquals(TAG+" UPDATE ENTITY","Encore",newEntity.getFirstName());

        pEditorRepo.delete(updateEntity);
        PhotoEditor deletedEntity=pEditorRepo.findById(id);
        Assert.assertNull(TAG+" DELETE ",deletedEntity);
    }
}
