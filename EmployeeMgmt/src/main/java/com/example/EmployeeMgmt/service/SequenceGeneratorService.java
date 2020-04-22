package com.example.EmployeeMgmt.service;

import static org.springframework.data.mongodb.core.FindAndModifyOptions.options;
import static org.springframework.data.mongodb.core.query.Criteria.where;
import static org.springframework.data.mongodb.core.query.Query.query;

import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Service;

import com.example.EmployeeMgmt.models.Emp_Leave_Sequence;
import com.example.EmployeeMgmt.models.Emp_Notice_Sequence;
import com.example.EmployeeMgmt.models.Emp_leave_Req_Sequence;
import com.example.EmployeeMgmt.models.HR_Sequence;

@Service
public class SequenceGeneratorService {


    private MongoOperations mongoOperations;

    @Autowired
    public SequenceGeneratorService(MongoOperations mongoOperations) {
        this.mongoOperations = mongoOperations;
    }

    public String generateNoticeSequence(String seqName) {

        Emp_Notice_Sequence counter = mongoOperations.findAndModify(query(where("_id").is(seqName)),
                new Update().inc("seq",1), options().returnNew(true).upsert(true),
                Emp_Notice_Sequence.class);
        return !Objects.isNull(counter) ? counter.getSeq() : "1";

    }
    public String generateHrSequence(String seqName) {
        HR_Sequence counter = mongoOperations.findAndModify(query(where("_id").is(seqName)),
                new Update().inc("seq",1), options().returnNew(true).upsert(true),
                HR_Sequence.class);
        return !Objects.isNull(counter) ? counter.getSeq() : "1";

    }
//    public String generateLeaveReqSequence(String seqName) {
//
//        Emp_Leave_Req_Sequence counter = mongoOperations.findAndModify(query(where("_id").is(seqName)),
//                new Update().inc("seq",1), options().returnNew(true).upsert(true),
//                Emp_leave_Req_Sequence.class);
//        return !Objects.isNull(counter) ? counter.getSeq() : "1";
//
//    }
    public int generateLeaveSequence(String seqName) {

        Emp_Leave_Sequence counter = mongoOperations.findAndModify(query(where("_id").is(seqName)),
                new Update().inc("seq",1), options().returnNew(true).upsert(true),
                Emp_Leave_Sequence.class);
        return !Objects.isNull(counter) ? counter.getSeq() : 1;

    }
}