package com.jmatheus.portfolio.portfolio.controllers.admin.framework;

import com.jmatheus.portfolio.portfolio.responses.ResponseOk;
import com.jmatheus.portfolio.portfolio.services.dto.in.admin.framework.CreateFrameworkDto;
import com.jmatheus.portfolio.portfolio.services.dto.in.admin.framework.DeleteFrameworkDto;
import com.jmatheus.portfolio.portfolio.services.dto.in.admin.framework.ShowFrameworkDto;
import com.jmatheus.portfolio.portfolio.services.dto.in.admin.framework.UpdateFrameworkDto;
import com.jmatheus.portfolio.portfolio.services.dto.out.admin.framework.CreatedFrameworkDto;
import com.jmatheus.portfolio.portfolio.services.dto.out.admin.framework.ListedFrameworkDto;
import com.jmatheus.portfolio.portfolio.services.dto.out.admin.framework.ShowedFrameworkDto;
import com.jmatheus.portfolio.portfolio.services.dto.out.admin.framework.UpdatedFrameworkDto;
import com.jmatheus.portfolio.portfolio.services.framework.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/admin/framework")
public class FrameworkController {
    @Autowired
    private InsertFrameworkService insertFrameworkService;

    @Autowired
    private ListFrameworkService listFrameworkService;

    @Autowired
    private ShowFrameworkService showFrameworkService;

    @Autowired
    private UpdateFrameworkService updateFrameworkService;

    @Autowired
    private DeleteFrameworkService deleteFrameworkService;

    @GetMapping
    public ResponseEntity<ResponseOk> list() {
        ListedFrameworkDto listedFramework = listFrameworkService.execute();
        return ResponseEntity.status(HttpStatus.OK).body(new ResponseOk("Success", listedFramework.getData()));
    }

    @GetMapping("/{id}")
    public ResponseEntity<ResponseOk> show(@PathVariable Long id) {
        ShowedFrameworkDto showedFramework = showFrameworkService.execute(new ShowFrameworkDto(id));
        return ResponseEntity.status(HttpStatus.OK).body(new ResponseOk("Success", showedFramework.getData()));
    }

    @PostMapping
    public ResponseEntity<ResponseOk> create(@RequestBody CreateFrameworkDto data) {
        CreatedFrameworkDto createdFramework = insertFrameworkService.execute(data);
        return ResponseEntity.status(HttpStatus.CREATED).body(new ResponseOk("Created", createdFramework));
    }

    @PutMapping
    public ResponseEntity<ResponseOk> update(@RequestBody UpdateFrameworkDto data) {
        UpdatedFrameworkDto updatedFramework = updateFrameworkService.execute(data);
        return ResponseEntity.status(HttpStatus.CREATED).body(new ResponseOk("Success", updatedFramework.getData()));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        deleteFrameworkService.execute(new DeleteFrameworkDto(id));
        return ResponseEntity.noContent().build();
    }
}
