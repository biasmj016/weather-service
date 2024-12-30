import static io.grpc.MethodDescriptor.generateFullMethodName;

/**
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler (version 1.69.0)",
    comments = "Source: weatherService.proto")
@io.grpc.stub.annotations.GrpcGenerated
public final class WeatherUseCaseGrpc {

  private WeatherUseCaseGrpc() {}

  public static final java.lang.String SERVICE_NAME = "WeatherUseCase";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<WeatherService.WeatherRequest,
      WeatherService.WeatherResponse> getGetCurrentWeatherMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetCurrentWeather",
      requestType = WeatherService.WeatherRequest.class,
      responseType = WeatherService.WeatherResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<WeatherService.WeatherRequest,
      WeatherService.WeatherResponse> getGetCurrentWeatherMethod() {
    io.grpc.MethodDescriptor<WeatherService.WeatherRequest, WeatherService.WeatherResponse> getGetCurrentWeatherMethod;
    if ((getGetCurrentWeatherMethod = WeatherUseCaseGrpc.getGetCurrentWeatherMethod) == null) {
      synchronized (WeatherUseCaseGrpc.class) {
        if ((getGetCurrentWeatherMethod = WeatherUseCaseGrpc.getGetCurrentWeatherMethod) == null) {
          WeatherUseCaseGrpc.getGetCurrentWeatherMethod = getGetCurrentWeatherMethod =
              io.grpc.MethodDescriptor.<WeatherService.WeatherRequest, WeatherService.WeatherResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "GetCurrentWeather"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  WeatherService.WeatherRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  WeatherService.WeatherResponse.getDefaultInstance()))
              .setSchemaDescriptor(new WeatherUseCaseMethodDescriptorSupplier("GetCurrentWeather"))
              .build();
        }
      }
    }
    return getGetCurrentWeatherMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static WeatherUseCaseStub newStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<WeatherUseCaseStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<WeatherUseCaseStub>() {
        @java.lang.Override
        public WeatherUseCaseStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new WeatherUseCaseStub(channel, callOptions);
        }
      };
    return WeatherUseCaseStub.newStub(factory, channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static WeatherUseCaseBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<WeatherUseCaseBlockingStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<WeatherUseCaseBlockingStub>() {
        @java.lang.Override
        public WeatherUseCaseBlockingStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new WeatherUseCaseBlockingStub(channel, callOptions);
        }
      };
    return WeatherUseCaseBlockingStub.newStub(factory, channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static WeatherUseCaseFutureStub newFutureStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<WeatherUseCaseFutureStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<WeatherUseCaseFutureStub>() {
        @java.lang.Override
        public WeatherUseCaseFutureStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new WeatherUseCaseFutureStub(channel, callOptions);
        }
      };
    return WeatherUseCaseFutureStub.newStub(factory, channel);
  }

  /**
   */
  public interface AsyncService {

    /**
     */
    default void getCurrentWeather(WeatherService.WeatherRequest request,
        io.grpc.stub.StreamObserver<WeatherService.WeatherResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getGetCurrentWeatherMethod(), responseObserver);
    }
  }

  /**
   * Base class for the server implementation of the service WeatherUseCase.
   */
  public static abstract class WeatherUseCaseImplBase
      implements io.grpc.BindableService, AsyncService {

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return WeatherUseCaseGrpc.bindService(this);
    }
  }

  /**
   * A stub to allow clients to do asynchronous rpc calls to service WeatherUseCase.
   */
  public static final class WeatherUseCaseStub
      extends io.grpc.stub.AbstractAsyncStub<WeatherUseCaseStub> {
    private WeatherUseCaseStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected WeatherUseCaseStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new WeatherUseCaseStub(channel, callOptions);
    }

    /**
     */
    public void getCurrentWeather(WeatherService.WeatherRequest request,
        io.grpc.stub.StreamObserver<WeatherService.WeatherResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGetCurrentWeatherMethod(), getCallOptions()), request, responseObserver);
    }
  }

  /**
   * A stub to allow clients to do synchronous rpc calls to service WeatherUseCase.
   */
  public static final class WeatherUseCaseBlockingStub
      extends io.grpc.stub.AbstractBlockingStub<WeatherUseCaseBlockingStub> {
    private WeatherUseCaseBlockingStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected WeatherUseCaseBlockingStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new WeatherUseCaseBlockingStub(channel, callOptions);
    }

    /**
     */
    public WeatherService.WeatherResponse getCurrentWeather(WeatherService.WeatherRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetCurrentWeatherMethod(), getCallOptions(), request);
    }
  }

  /**
   * A stub to allow clients to do ListenableFuture-style rpc calls to service WeatherUseCase.
   */
  public static final class WeatherUseCaseFutureStub
      extends io.grpc.stub.AbstractFutureStub<WeatherUseCaseFutureStub> {
    private WeatherUseCaseFutureStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected WeatherUseCaseFutureStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new WeatherUseCaseFutureStub(channel, callOptions);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<WeatherService.WeatherResponse> getCurrentWeather(
        WeatherService.WeatherRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGetCurrentWeatherMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_GET_CURRENT_WEATHER = 0;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final AsyncService serviceImpl;
    private final int methodId;

    MethodHandlers(AsyncService serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_GET_CURRENT_WEATHER:
          serviceImpl.getCurrentWeather((WeatherService.WeatherRequest) request,
              (io.grpc.stub.StreamObserver<WeatherService.WeatherResponse>) responseObserver);
          break;
        default:
          throw new AssertionError();
      }
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public io.grpc.stub.StreamObserver<Req> invoke(
        io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        default:
          throw new AssertionError();
      }
    }
  }

  public static final io.grpc.ServerServiceDefinition bindService(AsyncService service) {
    return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
        .addMethod(
          getGetCurrentWeatherMethod(),
          io.grpc.stub.ServerCalls.asyncUnaryCall(
            new MethodHandlers<
              WeatherService.WeatherRequest,
              WeatherService.WeatherResponse>(
                service, METHODID_GET_CURRENT_WEATHER)))
        .build();
  }

  private static abstract class WeatherUseCaseBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    WeatherUseCaseBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return WeatherService.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("WeatherUseCase");
    }
  }

  private static final class WeatherUseCaseFileDescriptorSupplier
      extends WeatherUseCaseBaseDescriptorSupplier {
    WeatherUseCaseFileDescriptorSupplier() {}
  }

  private static final class WeatherUseCaseMethodDescriptorSupplier
      extends WeatherUseCaseBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final java.lang.String methodName;

    WeatherUseCaseMethodDescriptorSupplier(java.lang.String methodName) {
      this.methodName = methodName;
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.MethodDescriptor getMethodDescriptor() {
      return getServiceDescriptor().findMethodByName(methodName);
    }
  }

  private static volatile io.grpc.ServiceDescriptor serviceDescriptor;

  public static io.grpc.ServiceDescriptor getServiceDescriptor() {
    io.grpc.ServiceDescriptor result = serviceDescriptor;
    if (result == null) {
      synchronized (WeatherUseCaseGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new WeatherUseCaseFileDescriptorSupplier())
              .addMethod(getGetCurrentWeatherMethod())
              .build();
        }
      }
    }
    return result;
  }
}
