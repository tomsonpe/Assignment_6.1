package com.assignment_7.repository;

import android.test.AndroidTestCase;
import com.assignment_7.domain.Videos;
import com.assignment_7.repositories.repository.VideoRepository;
import com.assignment_7.repositories.repositoryImplem.VideoRepositoryImplem;

import junit.framework.Assert;
import java.util.Set;

/**
 * Created by Phinda Encore Tomson on 4/21/2016.
 */
public class VideoRepositoryTest extends AndroidTestCase {
    private static final String TAG="VIDEO EDITOR TEST";
    private Long id;

    public void testCreateReadUpdateDelete() throws Exception{
        VideoRepository videoRepo=new VideoRepositoryImplem(this.getContext());
        Videos createEntity=new Videos.Builder()
                .first("Encore")
                .last("Tomson")
                .build();

        Videos insertedEntity=videoRepo.save(createEntity);
        id=insertedEntity.getId();
        Assert.assertNotNull(TAG + " CREATE ", insertedEntity);

        Set<Videos> video=videoRepo.findAll();
        Assert.assertTrue(TAG + " READ ALL ", video.size() > 0);

        Videos entity=videoRepo.findById(id);
        Assert.assertNotNull(TAG + " READ ENTITY ", entity);

        Videos updateEntity=new Videos.Builder()
                .copy(entity)
                .first("Encore")
                .last("Tomson")
                .build();
        videoRepo.update(updateEntity);
        Videos newEntity=videoRepo.findById(id);
        Assert.assertEquals(TAG+" UPDATE ENTITY","Encore",newEntity.getCameramanFirstName());

        videoRepo.delete(updateEntity);
        Videos deletedEntity=videoRepo.findById(id);
        Assert.assertNull(TAG+" DELETE ",deletedEntity);
    }
}
