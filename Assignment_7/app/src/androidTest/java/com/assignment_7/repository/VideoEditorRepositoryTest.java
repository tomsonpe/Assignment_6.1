package com.assignment_7.repository;

import android.test.AndroidTestCase;

import com.assignment_7.domain.VideoEditor;
import com.assignment_7.repositories.repository.VideoEditorRepository;
import com.assignment_7.repositories.repositoryImplem.VideoEditorRepositoryImplem;

import junit.framework.Assert;

import java.util.Set;

/**
 *Created by Phinda Encore Tomson on 4/21/2016.
 */
public class VideoEditorRepositoryTest extends AndroidTestCase {
    private static final String TAG="VIDEO EDITOR TEST";
    private Long id;

    public void testCreateReadUpdateDelete() throws Exception{
        VideoEditorRepository vEditorRepo=new VideoEditorRepositoryImplem(this.getContext());
        VideoEditor createEntity=new VideoEditor.Builder()
                .first("Encore")
                .last("Tomson")
                .build();

        VideoEditor insertedEntity=vEditorRepo.save(createEntity);
        id=insertedEntity.getId();
        Assert.assertNotNull(TAG + " CREATE ", insertedEntity);

        Set<VideoEditor> vEditor=vEditorRepo.findAll();
        Assert.assertTrue(TAG + " READ ALL ", vEditor.size() > 0);

        VideoEditor entity=vEditorRepo.findById(id);
        Assert.assertNotNull(TAG + " READ ENTITY ", entity);

        VideoEditor updateEntity=new VideoEditor.Builder()
                .copy(entity)
                .first("Encore")
                .last("Tomson")
                .build();
        vEditorRepo.update(updateEntity);
        VideoEditor newEntity=vEditorRepo.findById(id);
        Assert.assertEquals(TAG+" UPDATE ENTITY","Encore",newEntity.getFirstName());

        vEditorRepo.delete(updateEntity);
        VideoEditor deletedEntity=vEditorRepo.findById(id);
        Assert.assertNull(TAG+" DELETE ",deletedEntity);
    }
}
