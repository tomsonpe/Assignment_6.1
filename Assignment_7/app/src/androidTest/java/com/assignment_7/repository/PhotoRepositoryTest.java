package com.assignment_7.repository;

import android.test.AndroidTestCase;

import com.assignment_7.domain.Photos;
import com.assignment_7.repositories.repository.PhotoRepository;
import com.assignment_7.repositories.repositoryImplem.PhotoRepositoryImplem;

import junit.framework.Assert;

import java.util.Set;

/**
 *Created by Phinda Encore Tomson on 4/21/2016.
 */
public class PhotoRepositoryTest extends AndroidTestCase {
    private static final String TAG="VIDEO EDITOR TEST";
    private Long id;

    public void testCreateReadUpdateDelete() throws Exception{
        PhotoRepository photoRepo=new PhotoRepositoryImplem(this.getContext());
        Photos createEntity=new Photos.Builder()
                .first("Encore")
                .last("Tomson")
                .build();

        Photos insertedEntity=photoRepo.save(createEntity);
        id=insertedEntity.getId();
        Assert.assertNotNull(TAG + " CREATE ", insertedEntity);

        Set<Photos> photo=photoRepo.findAll();
        Assert.assertTrue(TAG + " READ ALL ", photo.size() > 0);

        Photos entity=photoRepo.findById(id);
        Assert.assertNotNull(TAG + " READ ENTITY ", entity);

        Photos updateEntity=new Photos.Builder()
                .copy(entity)
                .first("Encore")
                .last("Tomson")
                .build();
        photoRepo.update(updateEntity);
        Photos newEntity=photoRepo.findById(id);
        Assert.assertEquals(TAG+" UPDATE ENTITY","Encore",newEntity.getCameramanFirstName());

        photoRepo.delete(updateEntity);
        Photos deletedEntity=photoRepo.findById(id);
        Assert.assertNull(TAG+" DELETE ",deletedEntity);
    }

}
