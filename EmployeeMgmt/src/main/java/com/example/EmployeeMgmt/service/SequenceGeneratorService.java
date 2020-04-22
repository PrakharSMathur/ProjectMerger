package com.example.EmployeeMgmt.service;

import static org.springframework.data.mongodb.core.FindAndModifyOptions.options;
import static org.springframework.data.mongodb.core.query.Criteria.where;
import static org.springframework.data.mongodb.core.query.Query.query;

import com.example.EmployeeMgmt.model.*;

import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Service;

@Service
public class SequenceGeneratorService {

  private static MongoOperations mongoOperations;

  @Autowired
  public SequenceGeneratorService(MongoOperations mongoOperations) {
    this.mongoOperations = mongoOperations;
  }

  public static String generateEmpIDSequence(String seqName) {
    Employee_Sequence counter = mongoOperations.findAndModify(query(where("_id").is(seqName)),
        new Update().inc("seq", 1), options().returnNew(true).upsert(true),
        Employee_Sequence.class);
    return !Objects.isNull(counter) ? counter.getSeq() : "1";
  }

  public static String generateHrIDSequence(String seqName) {
    HR_Sequence counter = mongoOperations.findAndModify(query(where("_id").is(seqName)),
        new Update().inc("seq", 1), options().returnNew(true).upsert(true),
        HR_Sequence.class);
    return !Objects.isNull(counter) ? counter.getSeq() : "1";
  }

  public static String generateEmpLeaveSequence(String seqName) {
    Employee_Leave_Sequence counter = mongoOperations.findAndModify(query(where("_id").is(seqName)),
        new Update().inc("seq", 1), options().returnNew(true).upsert(true),
        Employee_Leave_Sequence.class);
    return !Objects.isNull(counter) ? counter.getSeq() : "1";
  }

  public static String generateEmpNoticeSequence(String seqName) {
    Employee_Notice_Sequence counter = mongoOperations.findAndModify(query(where("_id").is(seqName)),
        new Update().inc("seq", 1), options().returnNew(true).upsert(true),
        Employee_Notice_Sequence.class);
    return !Objects.isNull(counter) ? counter.getSeq() : "1";
  }

  public static String generateHRNoticeSequence(String seqName) {
    HR_Notice_Sequence counter = mongoOperations.findAndModify(query(where("_id").is(seqName)),
        new Update().inc("seq", 1), options().returnNew(true).upsert(true),
        HR_Notice_Sequence.class);
    return !Objects.isNull(counter) ? counter.getSeq() : "1";
  }
/*
  public String generateAdminReqSequence(String seqName) {
    Admin_Request_Sequence counter = mongoOperations.findAndModify(query(where("_id").is(seqName)),
        new Update().inc("seq", 1), options().returnNew(true).upsert(true),
        Admin_Request_Sequence.class);
    return !Objects.isNull(counter) ? counter.getSeq() : "1";
  }
*/

}