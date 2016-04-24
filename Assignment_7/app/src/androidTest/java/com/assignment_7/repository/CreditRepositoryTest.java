package com.assignment_7.repository;

import android.test.AndroidTestCase;

import com.assignment_7.domain.Credit;
import com.assignment_7.repositories.repository.CreditRepository;
import com.assignment_7.repositories.repositoryImplem.CreditRepositoryimplem;

import junit.framework.Assert;
import java.util.Set;

/**
 *Created by Phinda Encore Tomson on 4/21/2016.
 */
public class CreditRepositoryTest extends AndroidTestCase {
    private static final String TAG="CREDIT TEST";
    private Long id;

    public void testCreateReadUpdateDelete() throws Exception{
        CreditRepository creditRepo=new CreditRepositoryimplem(this.getContext());
        Credit createEntity=new Credit.Builder()
                .no("50000")
                .name("Encore")
                .build();

        Credit insertedEntity=creditRepo.save(createEntity);
        id=insertedEntity.getId();
        Assert.assertNotNull(TAG + " CREATE ", insertedEntity);

        Set<Credit> credit=creditRepo.findAll();
        Assert.assertTrue(TAG + " READ ALL ", credit.size() > 0);

        Credit entity=creditRepo.findById(id);
        Assert.assertNotNull(TAG + " READ ENTITY ", entity);

        Credit updateEntity=new Credit.Builder()
                .copy(entity)
                .name("Encore")
                .build();
        creditRepo.update(updateEntity);
        Credit newEntity=creditRepo.findById(id);
        Assert.assertEquals(TAG+" UPDATE ENTITY","ENCORE",newEntity.getName());

        creditRepo.delete(updateEntity);
        Credit deletedEntity=creditRepo.findById(id);
        Assert.assertNull(TAG+" DELETE ",deletedEntity);
    }
}
