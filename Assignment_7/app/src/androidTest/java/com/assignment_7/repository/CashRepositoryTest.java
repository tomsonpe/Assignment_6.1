package com.assignment_7.repository;

import android.test.AndroidTestCase;

import com.assignment_7.domain.Cash;
import com.assignment_7.repositories.repository.CashRepository;
import com.assignment_7.repositories.repositoryImplem.CashRepositoryImplem;

import junit.framework.Assert;

import java.util.Set;

/**
 *Created by Phinda Encore Tomson on 4/21/2016.
 */
public class CashRepositoryTest extends AndroidTestCase {
    private static final String TAG="CASH TEST";
    private Long id;

    public void testCreateReadUpdateDelete() throws Exception{
        CashRepository cashRepo=new CashRepositoryImplem(this.getContext());
        Cash createEntity=new Cash.Builder()
                .amount("50000")
                .name("Encore")
                .build();

        Cash insertedEntity=cashRepo.save(createEntity);
        id=insertedEntity.getId();
        Assert.assertNotNull(TAG + " CREATE ", insertedEntity);

        Set<Cash> cash=cashRepo.findAll();
        Assert.assertTrue(TAG + " READ ALL ", cash.size() > 0);

        Cash entity=cashRepo.findById(id);
        Assert.assertNotNull(TAG+" READ ENTITY ",entity);

        Cash updateEntity=new Cash.Builder()
                .copy(entity)
                .name("Encore")
                .build();
        cashRepo.update(updateEntity);
        Cash newEntity=cashRepo.findById(id);
        Assert.assertEquals(TAG+" UPDATE ENTITY","Encore",newEntity.getName());

        cashRepo.delete(updateEntity);
        Cash deletedEntity=cashRepo.findById(id);
        Assert.assertNull(TAG+" DELETE ",deletedEntity);
    }

}
