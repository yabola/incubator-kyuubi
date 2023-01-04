/*
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.apache.kyuubi.plugin.spark.authz.gen

import org.apache.kyuubi.plugin.spark.authz.serde.{CatalogTableOptionTableExtractor, CatalogTableTableExtractor, DataSourceV2RelationTableExtractor, ScanDesc, ScanSpec}

object Scans {

  val HiveTableRelation = {
    val r = "org.apache.spark.sql.catalyst.catalog.HiveTableRelation"
    val tableDesc =
      ScanDesc(
        "tableMeta",
        classOf[CatalogTableTableExtractor].getSimpleName)
    ScanSpec(r, Seq(tableDesc))
  }

  val LogicalRelation = {
    val r = "org.apache.spark.sql.execution.datasources.LogicalRelation"
    val tableDesc =
      ScanDesc(
        "catalogTable",
        classOf[CatalogTableOptionTableExtractor].getSimpleName)
    ScanSpec(r, Seq(tableDesc))
  }

  val DataSourceV2Relation = {
    val r = "org.apache.spark.sql.execution.datasources.v2.DataSourceV2Relation"
    val tableDesc =
      ScanDesc(
        null,
        classOf[DataSourceV2RelationTableExtractor].getSimpleName)
    ScanSpec(r, Seq(tableDesc))
  }

  val PermanentViewMarker = {
    val r = "org.apache.kyuubi.plugin.spark.authz.util.PermanentViewMarker"
    val tableDesc =
      ScanDesc(
        "catalogTable",
        classOf[CatalogTableTableExtractor].getSimpleName)
    ScanSpec(r, Seq(tableDesc))
  }

  val data = Array(
    HiveTableRelation,
    LogicalRelation,
    DataSourceV2Relation,
    PermanentViewMarker)
}