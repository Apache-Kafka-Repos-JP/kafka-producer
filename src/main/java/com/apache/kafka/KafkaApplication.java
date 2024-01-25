package com.apache.kafka;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@Slf4j
public class KafkaApplication {

	public static void main(String[] args) throws InterruptedException {

		SpringApplication.run(KafkaApplication.class, args);
		/*
			A broker is used as a middleware between Service A and Service B
			Benefits of EDA:
				Decoupling
				Encapsulation
				Optimization
				Scalability

			Drawbacks of EDA:
				Steep learning curve
				Complexity (what happens if something wrong between communication)
				Loss of transactionality
				Lineage (debugging). Solution to this is create an identifier to the event
		 */

		/*
		Kafka:
		Benefits:
			Open source
			Java
			High throughput (Zero copy, message in a hard drive, only for non-TLS connections)
				Only handles BYTES. No serialization or deserialization
				All the data that is passed to kafka is in binary format
			More than a messaging system:
				Messaging system (publish/subscribe pattern)
				Distributed storage (store data in a fault-tolerant, durable way)
				Data processing - streaming (process events as they occur)


		Components:
			Broker: lives in a dedicated server with dedicated resources. Is a proccess which leaves at top of the OS
			when a message is receive over the network the broker persist it in the hard drive
			Kafka cluster consists of more than 1 broker in a specific context, when a message is receive it is being replicated in all brokers

			Zookeper: Broker doesn't know each other. Zookeper maintans configuration across brokers, it serves as a broker discovery



		Messages transmited in Kafka are call RECORDS
		Record: Consist of Key, Value and Timestamp. Default limit is 1MB
		All the messages can be categorized in a topic
		Topics are stored in a broker

		Two kind of topics:
		Delete: Max size: 20KB, when new messages are inserted in topics old ones are deleted
				Retention time: 1 day. You can specify retention time of messages within a topic

		Compaction topics: When a new message with the same KEY are inserted, the old message with that key is deleted

		Partitions:
		The same topic is placed into multiple partitions and each partition lives in multiple brokers.
		Each partition stores different messages unless it has been produced multiple times.


		Producer:
		Application creates message with KEY, VALUE , then it is being serialize (property in app.properties) then convert to bytes and then send it to KAFKA

		Using Avro with Kafka instead of plain JSON or string serialization offers several benefits, especially in the context of data serialization and storage. Here are some advantages:

		Schema Evolution and Compatibility:

		Forward Compatibility: Avro supports schema evolution, allowing you to add new fields to your data schema without breaking compatibility with existing consumers.
		Backward Compatibility: Existing consumers can still read data produced with an older schema, even if new fields have been added.
		Compact Binary Format:

		Avro uses a compact binary format, which is more space-efficient compared to plain JSON or string serialization. This can result in reduced storage costs and improved network transfer efficiency.
		Efficient Serialization and Deserialization:

		Avro's binary format is more efficient to serialize and deserialize compared to text-based formats like JSON. This can lead to better overall performance, especially in high-throughput scenarios.

		Kafka streams: Save as for trouble setting up consumers and producers into a compact format to be easy to use
		Topology = acyclic graph of sources, processors, and sinks
		Consumer = Has a source where we extract data from
		Producer = Sink procesor is the final destination of the data

		Process step by step:
		1) Message from topic will be read from the consumer
		2) Message will be redirected to the first proccesor. For example a filter. If it is not rejected it will pass to the next processor
		3) Process will we a Map, so message will be transformed to something else.
		4) Last processor for example can be a count of messages. Here we can use a State Store to store messages in a hard drive or external source
		5) Last step will be Producer that takes the message and send it to topic

		In an event driven application is not enough kafka streams,
		Stream: Processing independent events (delete topics) (for example an order for an ecommerce)
		Table: Processing evolving events (compaction topics) (for example an account balance)

		Processors:
		Stateless: Do not require state for processing.
			Stateles operations:
				branch: split our stream in multiple branches based on business logic
				filter: rejecting messages based on condition
				Inverse Filter: opposite
				Map: Transform from one type to another
				FlatMap: List to object
				Foreach: iterate each event
				Peek: Inspect element into the streams
				GroupBy: Groupy by the key
				Merge: Combine two streams into a single one
		Stateful: Require a state store
			Stateful operations:
				Aggregations: SUM of transactions in a topic
				count:Count messages with the same key
				Joins: Join stream or table
				Windowing: interval of times in which we can perform oprations
				Custom processors: Lower level API to create our own operations


	 */
	}


}
