/*
 * Copyright (C) 2010 Google, Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.google.inject.persist.jpa;

import static org.junit.Assert.assertThrows;

import com.google.inject.Injector;
import com.google.inject.persist.PersistService;
import com.google.inject.persist.utils.PersistenceInjectorResource;
import org.junit.ClassRule;
import org.junit.Rule;
import org.junit.Test;

/** @author Dhanji R. Prasanna (dhanji@gmail.com) */

public class JpaWorkManagerTest {
  @ClassRule
  @Rule
  public static PersistenceInjectorResource injector = new PersistenceInjectorResource("testUnit");

  @Test
  public void testCloseMoreThanOnce() {
    injector.getInstance(PersistService.class).stop();

    assertThrows(IllegalStateException.class, () -> injector.getInstance(PersistService.class).stop());
  }
}
