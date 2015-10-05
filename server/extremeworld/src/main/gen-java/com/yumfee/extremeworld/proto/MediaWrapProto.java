// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: MediaWrapDTO.proto

package com.yumfee.extremeworld.proto;

public final class MediaWrapProto {
  private MediaWrapProto() {}
  public static void registerAllExtensions(
      com.google.protobuf.ExtensionRegistry registry) {
  }
  public interface MediaWrapDTOOrBuilder extends
      // @@protoc_insertion_point(interface_extends:com.yumfee.extremeworld.proto.MediaWrapDTO)
      com.google.protobuf.MessageOrBuilder {

    /**
     * <code>required string createTime = 1;</code>
     */
    boolean hasCreateTime();
    /**
     * <code>required string createTime = 1;</code>
     */
    java.lang.String getCreateTime();
    /**
     * <code>required string createTime = 1;</code>
     */
    com.google.protobuf.ByteString
        getCreateTimeBytes();

    /**
     * <code>repeated .com.yumfee.extremeworld.proto.MediaDTO medias = 2;</code>
     */
    java.util.List<com.yumfee.extremeworld.proto.MediaProto.MediaDTO> 
        getMediasList();
    /**
     * <code>repeated .com.yumfee.extremeworld.proto.MediaDTO medias = 2;</code>
     */
    com.yumfee.extremeworld.proto.MediaProto.MediaDTO getMedias(int index);
    /**
     * <code>repeated .com.yumfee.extremeworld.proto.MediaDTO medias = 2;</code>
     */
    int getMediasCount();
    /**
     * <code>repeated .com.yumfee.extremeworld.proto.MediaDTO medias = 2;</code>
     */
    java.util.List<? extends com.yumfee.extremeworld.proto.MediaProto.MediaDTOOrBuilder> 
        getMediasOrBuilderList();
    /**
     * <code>repeated .com.yumfee.extremeworld.proto.MediaDTO medias = 2;</code>
     */
    com.yumfee.extremeworld.proto.MediaProto.MediaDTOOrBuilder getMediasOrBuilder(
        int index);
  }
  /**
   * Protobuf type {@code com.yumfee.extremeworld.proto.MediaWrapDTO}
   */
  public static final class MediaWrapDTO extends
      com.google.protobuf.GeneratedMessage implements
      // @@protoc_insertion_point(message_implements:com.yumfee.extremeworld.proto.MediaWrapDTO)
      MediaWrapDTOOrBuilder {
    // Use MediaWrapDTO.newBuilder() to construct.
    private MediaWrapDTO(com.google.protobuf.GeneratedMessage.Builder<?> builder) {
      super(builder);
      this.unknownFields = builder.getUnknownFields();
    }
    private MediaWrapDTO(boolean noInit) { this.unknownFields = com.google.protobuf.UnknownFieldSet.getDefaultInstance(); }

    private static final MediaWrapDTO defaultInstance;
    public static MediaWrapDTO getDefaultInstance() {
      return defaultInstance;
    }

    public MediaWrapDTO getDefaultInstanceForType() {
      return defaultInstance;
    }

    private final com.google.protobuf.UnknownFieldSet unknownFields;
    @java.lang.Override
    public final com.google.protobuf.UnknownFieldSet
        getUnknownFields() {
      return this.unknownFields;
    }
    private MediaWrapDTO(
        com.google.protobuf.CodedInputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      initFields();
      int mutable_bitField0_ = 0;
      com.google.protobuf.UnknownFieldSet.Builder unknownFields =
          com.google.protobuf.UnknownFieldSet.newBuilder();
      try {
        boolean done = false;
        while (!done) {
          int tag = input.readTag();
          switch (tag) {
            case 0:
              done = true;
              break;
            default: {
              if (!parseUnknownField(input, unknownFields,
                                     extensionRegistry, tag)) {
                done = true;
              }
              break;
            }
            case 10: {
              com.google.protobuf.ByteString bs = input.readBytes();
              bitField0_ |= 0x00000001;
              createTime_ = bs;
              break;
            }
            case 18: {
              if (!((mutable_bitField0_ & 0x00000002) == 0x00000002)) {
                medias_ = new java.util.ArrayList<com.yumfee.extremeworld.proto.MediaProto.MediaDTO>();
                mutable_bitField0_ |= 0x00000002;
              }
              medias_.add(input.readMessage(com.yumfee.extremeworld.proto.MediaProto.MediaDTO.PARSER, extensionRegistry));
              break;
            }
          }
        }
      } catch (com.google.protobuf.InvalidProtocolBufferException e) {
        throw e.setUnfinishedMessage(this);
      } catch (java.io.IOException e) {
        throw new com.google.protobuf.InvalidProtocolBufferException(
            e.getMessage()).setUnfinishedMessage(this);
      } finally {
        if (((mutable_bitField0_ & 0x00000002) == 0x00000002)) {
          medias_ = java.util.Collections.unmodifiableList(medias_);
        }
        this.unknownFields = unknownFields.build();
        makeExtensionsImmutable();
      }
    }
    public static final com.google.protobuf.Descriptors.Descriptor
        getDescriptor() {
      return com.yumfee.extremeworld.proto.MediaWrapProto.internal_static_com_yumfee_extremeworld_proto_MediaWrapDTO_descriptor;
    }

    protected com.google.protobuf.GeneratedMessage.FieldAccessorTable
        internalGetFieldAccessorTable() {
      return com.yumfee.extremeworld.proto.MediaWrapProto.internal_static_com_yumfee_extremeworld_proto_MediaWrapDTO_fieldAccessorTable
          .ensureFieldAccessorsInitialized(
              com.yumfee.extremeworld.proto.MediaWrapProto.MediaWrapDTO.class, com.yumfee.extremeworld.proto.MediaWrapProto.MediaWrapDTO.Builder.class);
    }

    public static com.google.protobuf.Parser<MediaWrapDTO> PARSER =
        new com.google.protobuf.AbstractParser<MediaWrapDTO>() {
      public MediaWrapDTO parsePartialFrom(
          com.google.protobuf.CodedInputStream input,
          com.google.protobuf.ExtensionRegistryLite extensionRegistry)
          throws com.google.protobuf.InvalidProtocolBufferException {
        return new MediaWrapDTO(input, extensionRegistry);
      }
    };

    @java.lang.Override
    public com.google.protobuf.Parser<MediaWrapDTO> getParserForType() {
      return PARSER;
    }

    private int bitField0_;
    public static final int CREATETIME_FIELD_NUMBER = 1;
    private java.lang.Object createTime_;
    /**
     * <code>required string createTime = 1;</code>
     */
    public boolean hasCreateTime() {
      return ((bitField0_ & 0x00000001) == 0x00000001);
    }
    /**
     * <code>required string createTime = 1;</code>
     */
    public java.lang.String getCreateTime() {
      java.lang.Object ref = createTime_;
      if (ref instanceof java.lang.String) {
        return (java.lang.String) ref;
      } else {
        com.google.protobuf.ByteString bs = 
            (com.google.protobuf.ByteString) ref;
        java.lang.String s = bs.toStringUtf8();
        if (bs.isValidUtf8()) {
          createTime_ = s;
        }
        return s;
      }
    }
    /**
     * <code>required string createTime = 1;</code>
     */
    public com.google.protobuf.ByteString
        getCreateTimeBytes() {
      java.lang.Object ref = createTime_;
      if (ref instanceof java.lang.String) {
        com.google.protobuf.ByteString b = 
            com.google.protobuf.ByteString.copyFromUtf8(
                (java.lang.String) ref);
        createTime_ = b;
        return b;
      } else {
        return (com.google.protobuf.ByteString) ref;
      }
    }

    public static final int MEDIAS_FIELD_NUMBER = 2;
    private java.util.List<com.yumfee.extremeworld.proto.MediaProto.MediaDTO> medias_;
    /**
     * <code>repeated .com.yumfee.extremeworld.proto.MediaDTO medias = 2;</code>
     */
    public java.util.List<com.yumfee.extremeworld.proto.MediaProto.MediaDTO> getMediasList() {
      return medias_;
    }
    /**
     * <code>repeated .com.yumfee.extremeworld.proto.MediaDTO medias = 2;</code>
     */
    public java.util.List<? extends com.yumfee.extremeworld.proto.MediaProto.MediaDTOOrBuilder> 
        getMediasOrBuilderList() {
      return medias_;
    }
    /**
     * <code>repeated .com.yumfee.extremeworld.proto.MediaDTO medias = 2;</code>
     */
    public int getMediasCount() {
      return medias_.size();
    }
    /**
     * <code>repeated .com.yumfee.extremeworld.proto.MediaDTO medias = 2;</code>
     */
    public com.yumfee.extremeworld.proto.MediaProto.MediaDTO getMedias(int index) {
      return medias_.get(index);
    }
    /**
     * <code>repeated .com.yumfee.extremeworld.proto.MediaDTO medias = 2;</code>
     */
    public com.yumfee.extremeworld.proto.MediaProto.MediaDTOOrBuilder getMediasOrBuilder(
        int index) {
      return medias_.get(index);
    }

    private void initFields() {
      createTime_ = "";
      medias_ = java.util.Collections.emptyList();
    }
    private byte memoizedIsInitialized = -1;
    public final boolean isInitialized() {
      byte isInitialized = memoizedIsInitialized;
      if (isInitialized == 1) return true;
      if (isInitialized == 0) return false;

      if (!hasCreateTime()) {
        memoizedIsInitialized = 0;
        return false;
      }
      for (int i = 0; i < getMediasCount(); i++) {
        if (!getMedias(i).isInitialized()) {
          memoizedIsInitialized = 0;
          return false;
        }
      }
      memoizedIsInitialized = 1;
      return true;
    }

    public void writeTo(com.google.protobuf.CodedOutputStream output)
                        throws java.io.IOException {
      getSerializedSize();
      if (((bitField0_ & 0x00000001) == 0x00000001)) {
        output.writeBytes(1, getCreateTimeBytes());
      }
      for (int i = 0; i < medias_.size(); i++) {
        output.writeMessage(2, medias_.get(i));
      }
      getUnknownFields().writeTo(output);
    }

    private int memoizedSerializedSize = -1;
    public int getSerializedSize() {
      int size = memoizedSerializedSize;
      if (size != -1) return size;

      size = 0;
      if (((bitField0_ & 0x00000001) == 0x00000001)) {
        size += com.google.protobuf.CodedOutputStream
          .computeBytesSize(1, getCreateTimeBytes());
      }
      for (int i = 0; i < medias_.size(); i++) {
        size += com.google.protobuf.CodedOutputStream
          .computeMessageSize(2, medias_.get(i));
      }
      size += getUnknownFields().getSerializedSize();
      memoizedSerializedSize = size;
      return size;
    }

    private static final long serialVersionUID = 0L;
    @java.lang.Override
    protected java.lang.Object writeReplace()
        throws java.io.ObjectStreamException {
      return super.writeReplace();
    }

    public static com.yumfee.extremeworld.proto.MediaWrapProto.MediaWrapDTO parseFrom(
        com.google.protobuf.ByteString data)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data);
    }
    public static com.yumfee.extremeworld.proto.MediaWrapProto.MediaWrapDTO parseFrom(
        com.google.protobuf.ByteString data,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data, extensionRegistry);
    }
    public static com.yumfee.extremeworld.proto.MediaWrapProto.MediaWrapDTO parseFrom(byte[] data)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data);
    }
    public static com.yumfee.extremeworld.proto.MediaWrapProto.MediaWrapDTO parseFrom(
        byte[] data,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data, extensionRegistry);
    }
    public static com.yumfee.extremeworld.proto.MediaWrapProto.MediaWrapDTO parseFrom(java.io.InputStream input)
        throws java.io.IOException {
      return PARSER.parseFrom(input);
    }
    public static com.yumfee.extremeworld.proto.MediaWrapProto.MediaWrapDTO parseFrom(
        java.io.InputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws java.io.IOException {
      return PARSER.parseFrom(input, extensionRegistry);
    }
    public static com.yumfee.extremeworld.proto.MediaWrapProto.MediaWrapDTO parseDelimitedFrom(java.io.InputStream input)
        throws java.io.IOException {
      return PARSER.parseDelimitedFrom(input);
    }
    public static com.yumfee.extremeworld.proto.MediaWrapProto.MediaWrapDTO parseDelimitedFrom(
        java.io.InputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws java.io.IOException {
      return PARSER.parseDelimitedFrom(input, extensionRegistry);
    }
    public static com.yumfee.extremeworld.proto.MediaWrapProto.MediaWrapDTO parseFrom(
        com.google.protobuf.CodedInputStream input)
        throws java.io.IOException {
      return PARSER.parseFrom(input);
    }
    public static com.yumfee.extremeworld.proto.MediaWrapProto.MediaWrapDTO parseFrom(
        com.google.protobuf.CodedInputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws java.io.IOException {
      return PARSER.parseFrom(input, extensionRegistry);
    }

    public static Builder newBuilder() { return Builder.create(); }
    public Builder newBuilderForType() { return newBuilder(); }
    public static Builder newBuilder(com.yumfee.extremeworld.proto.MediaWrapProto.MediaWrapDTO prototype) {
      return newBuilder().mergeFrom(prototype);
    }
    public Builder toBuilder() { return newBuilder(this); }

    @java.lang.Override
    protected Builder newBuilderForType(
        com.google.protobuf.GeneratedMessage.BuilderParent parent) {
      Builder builder = new Builder(parent);
      return builder;
    }
    /**
     * Protobuf type {@code com.yumfee.extremeworld.proto.MediaWrapDTO}
     */
    public static final class Builder extends
        com.google.protobuf.GeneratedMessage.Builder<Builder> implements
        // @@protoc_insertion_point(builder_implements:com.yumfee.extremeworld.proto.MediaWrapDTO)
        com.yumfee.extremeworld.proto.MediaWrapProto.MediaWrapDTOOrBuilder {
      public static final com.google.protobuf.Descriptors.Descriptor
          getDescriptor() {
        return com.yumfee.extremeworld.proto.MediaWrapProto.internal_static_com_yumfee_extremeworld_proto_MediaWrapDTO_descriptor;
      }

      protected com.google.protobuf.GeneratedMessage.FieldAccessorTable
          internalGetFieldAccessorTable() {
        return com.yumfee.extremeworld.proto.MediaWrapProto.internal_static_com_yumfee_extremeworld_proto_MediaWrapDTO_fieldAccessorTable
            .ensureFieldAccessorsInitialized(
                com.yumfee.extremeworld.proto.MediaWrapProto.MediaWrapDTO.class, com.yumfee.extremeworld.proto.MediaWrapProto.MediaWrapDTO.Builder.class);
      }

      // Construct using com.yumfee.extremeworld.proto.MediaWrapProto.MediaWrapDTO.newBuilder()
      private Builder() {
        maybeForceBuilderInitialization();
      }

      private Builder(
          com.google.protobuf.GeneratedMessage.BuilderParent parent) {
        super(parent);
        maybeForceBuilderInitialization();
      }
      private void maybeForceBuilderInitialization() {
        if (com.google.protobuf.GeneratedMessage.alwaysUseFieldBuilders) {
          getMediasFieldBuilder();
        }
      }
      private static Builder create() {
        return new Builder();
      }

      public Builder clear() {
        super.clear();
        createTime_ = "";
        bitField0_ = (bitField0_ & ~0x00000001);
        if (mediasBuilder_ == null) {
          medias_ = java.util.Collections.emptyList();
          bitField0_ = (bitField0_ & ~0x00000002);
        } else {
          mediasBuilder_.clear();
        }
        return this;
      }

      public Builder clone() {
        return create().mergeFrom(buildPartial());
      }

      public com.google.protobuf.Descriptors.Descriptor
          getDescriptorForType() {
        return com.yumfee.extremeworld.proto.MediaWrapProto.internal_static_com_yumfee_extremeworld_proto_MediaWrapDTO_descriptor;
      }

      public com.yumfee.extremeworld.proto.MediaWrapProto.MediaWrapDTO getDefaultInstanceForType() {
        return com.yumfee.extremeworld.proto.MediaWrapProto.MediaWrapDTO.getDefaultInstance();
      }

      public com.yumfee.extremeworld.proto.MediaWrapProto.MediaWrapDTO build() {
        com.yumfee.extremeworld.proto.MediaWrapProto.MediaWrapDTO result = buildPartial();
        if (!result.isInitialized()) {
          throw newUninitializedMessageException(result);
        }
        return result;
      }

      public com.yumfee.extremeworld.proto.MediaWrapProto.MediaWrapDTO buildPartial() {
        com.yumfee.extremeworld.proto.MediaWrapProto.MediaWrapDTO result = new com.yumfee.extremeworld.proto.MediaWrapProto.MediaWrapDTO(this);
        int from_bitField0_ = bitField0_;
        int to_bitField0_ = 0;
        if (((from_bitField0_ & 0x00000001) == 0x00000001)) {
          to_bitField0_ |= 0x00000001;
        }
        result.createTime_ = createTime_;
        if (mediasBuilder_ == null) {
          if (((bitField0_ & 0x00000002) == 0x00000002)) {
            medias_ = java.util.Collections.unmodifiableList(medias_);
            bitField0_ = (bitField0_ & ~0x00000002);
          }
          result.medias_ = medias_;
        } else {
          result.medias_ = mediasBuilder_.build();
        }
        result.bitField0_ = to_bitField0_;
        onBuilt();
        return result;
      }

      public Builder mergeFrom(com.google.protobuf.Message other) {
        if (other instanceof com.yumfee.extremeworld.proto.MediaWrapProto.MediaWrapDTO) {
          return mergeFrom((com.yumfee.extremeworld.proto.MediaWrapProto.MediaWrapDTO)other);
        } else {
          super.mergeFrom(other);
          return this;
        }
      }

      public Builder mergeFrom(com.yumfee.extremeworld.proto.MediaWrapProto.MediaWrapDTO other) {
        if (other == com.yumfee.extremeworld.proto.MediaWrapProto.MediaWrapDTO.getDefaultInstance()) return this;
        if (other.hasCreateTime()) {
          bitField0_ |= 0x00000001;
          createTime_ = other.createTime_;
          onChanged();
        }
        if (mediasBuilder_ == null) {
          if (!other.medias_.isEmpty()) {
            if (medias_.isEmpty()) {
              medias_ = other.medias_;
              bitField0_ = (bitField0_ & ~0x00000002);
            } else {
              ensureMediasIsMutable();
              medias_.addAll(other.medias_);
            }
            onChanged();
          }
        } else {
          if (!other.medias_.isEmpty()) {
            if (mediasBuilder_.isEmpty()) {
              mediasBuilder_.dispose();
              mediasBuilder_ = null;
              medias_ = other.medias_;
              bitField0_ = (bitField0_ & ~0x00000002);
              mediasBuilder_ = 
                com.google.protobuf.GeneratedMessage.alwaysUseFieldBuilders ?
                   getMediasFieldBuilder() : null;
            } else {
              mediasBuilder_.addAllMessages(other.medias_);
            }
          }
        }
        this.mergeUnknownFields(other.getUnknownFields());
        return this;
      }

      public final boolean isInitialized() {
        if (!hasCreateTime()) {
          
          return false;
        }
        for (int i = 0; i < getMediasCount(); i++) {
          if (!getMedias(i).isInitialized()) {
            
            return false;
          }
        }
        return true;
      }

      public Builder mergeFrom(
          com.google.protobuf.CodedInputStream input,
          com.google.protobuf.ExtensionRegistryLite extensionRegistry)
          throws java.io.IOException {
        com.yumfee.extremeworld.proto.MediaWrapProto.MediaWrapDTO parsedMessage = null;
        try {
          parsedMessage = PARSER.parsePartialFrom(input, extensionRegistry);
        } catch (com.google.protobuf.InvalidProtocolBufferException e) {
          parsedMessage = (com.yumfee.extremeworld.proto.MediaWrapProto.MediaWrapDTO) e.getUnfinishedMessage();
          throw e;
        } finally {
          if (parsedMessage != null) {
            mergeFrom(parsedMessage);
          }
        }
        return this;
      }
      private int bitField0_;

      private java.lang.Object createTime_ = "";
      /**
       * <code>required string createTime = 1;</code>
       */
      public boolean hasCreateTime() {
        return ((bitField0_ & 0x00000001) == 0x00000001);
      }
      /**
       * <code>required string createTime = 1;</code>
       */
      public java.lang.String getCreateTime() {
        java.lang.Object ref = createTime_;
        if (!(ref instanceof java.lang.String)) {
          com.google.protobuf.ByteString bs =
              (com.google.protobuf.ByteString) ref;
          java.lang.String s = bs.toStringUtf8();
          if (bs.isValidUtf8()) {
            createTime_ = s;
          }
          return s;
        } else {
          return (java.lang.String) ref;
        }
      }
      /**
       * <code>required string createTime = 1;</code>
       */
      public com.google.protobuf.ByteString
          getCreateTimeBytes() {
        java.lang.Object ref = createTime_;
        if (ref instanceof String) {
          com.google.protobuf.ByteString b = 
              com.google.protobuf.ByteString.copyFromUtf8(
                  (java.lang.String) ref);
          createTime_ = b;
          return b;
        } else {
          return (com.google.protobuf.ByteString) ref;
        }
      }
      /**
       * <code>required string createTime = 1;</code>
       */
      public Builder setCreateTime(
          java.lang.String value) {
        if (value == null) {
    throw new NullPointerException();
  }
  bitField0_ |= 0x00000001;
        createTime_ = value;
        onChanged();
        return this;
      }
      /**
       * <code>required string createTime = 1;</code>
       */
      public Builder clearCreateTime() {
        bitField0_ = (bitField0_ & ~0x00000001);
        createTime_ = getDefaultInstance().getCreateTime();
        onChanged();
        return this;
      }
      /**
       * <code>required string createTime = 1;</code>
       */
      public Builder setCreateTimeBytes(
          com.google.protobuf.ByteString value) {
        if (value == null) {
    throw new NullPointerException();
  }
  bitField0_ |= 0x00000001;
        createTime_ = value;
        onChanged();
        return this;
      }

      private java.util.List<com.yumfee.extremeworld.proto.MediaProto.MediaDTO> medias_ =
        java.util.Collections.emptyList();
      private void ensureMediasIsMutable() {
        if (!((bitField0_ & 0x00000002) == 0x00000002)) {
          medias_ = new java.util.ArrayList<com.yumfee.extremeworld.proto.MediaProto.MediaDTO>(medias_);
          bitField0_ |= 0x00000002;
         }
      }

      private com.google.protobuf.RepeatedFieldBuilder<
          com.yumfee.extremeworld.proto.MediaProto.MediaDTO, com.yumfee.extremeworld.proto.MediaProto.MediaDTO.Builder, com.yumfee.extremeworld.proto.MediaProto.MediaDTOOrBuilder> mediasBuilder_;

      /**
       * <code>repeated .com.yumfee.extremeworld.proto.MediaDTO medias = 2;</code>
       */
      public java.util.List<com.yumfee.extremeworld.proto.MediaProto.MediaDTO> getMediasList() {
        if (mediasBuilder_ == null) {
          return java.util.Collections.unmodifiableList(medias_);
        } else {
          return mediasBuilder_.getMessageList();
        }
      }
      /**
       * <code>repeated .com.yumfee.extremeworld.proto.MediaDTO medias = 2;</code>
       */
      public int getMediasCount() {
        if (mediasBuilder_ == null) {
          return medias_.size();
        } else {
          return mediasBuilder_.getCount();
        }
      }
      /**
       * <code>repeated .com.yumfee.extremeworld.proto.MediaDTO medias = 2;</code>
       */
      public com.yumfee.extremeworld.proto.MediaProto.MediaDTO getMedias(int index) {
        if (mediasBuilder_ == null) {
          return medias_.get(index);
        } else {
          return mediasBuilder_.getMessage(index);
        }
      }
      /**
       * <code>repeated .com.yumfee.extremeworld.proto.MediaDTO medias = 2;</code>
       */
      public Builder setMedias(
          int index, com.yumfee.extremeworld.proto.MediaProto.MediaDTO value) {
        if (mediasBuilder_ == null) {
          if (value == null) {
            throw new NullPointerException();
          }
          ensureMediasIsMutable();
          medias_.set(index, value);
          onChanged();
        } else {
          mediasBuilder_.setMessage(index, value);
        }
        return this;
      }
      /**
       * <code>repeated .com.yumfee.extremeworld.proto.MediaDTO medias = 2;</code>
       */
      public Builder setMedias(
          int index, com.yumfee.extremeworld.proto.MediaProto.MediaDTO.Builder builderForValue) {
        if (mediasBuilder_ == null) {
          ensureMediasIsMutable();
          medias_.set(index, builderForValue.build());
          onChanged();
        } else {
          mediasBuilder_.setMessage(index, builderForValue.build());
        }
        return this;
      }
      /**
       * <code>repeated .com.yumfee.extremeworld.proto.MediaDTO medias = 2;</code>
       */
      public Builder addMedias(com.yumfee.extremeworld.proto.MediaProto.MediaDTO value) {
        if (mediasBuilder_ == null) {
          if (value == null) {
            throw new NullPointerException();
          }
          ensureMediasIsMutable();
          medias_.add(value);
          onChanged();
        } else {
          mediasBuilder_.addMessage(value);
        }
        return this;
      }
      /**
       * <code>repeated .com.yumfee.extremeworld.proto.MediaDTO medias = 2;</code>
       */
      public Builder addMedias(
          int index, com.yumfee.extremeworld.proto.MediaProto.MediaDTO value) {
        if (mediasBuilder_ == null) {
          if (value == null) {
            throw new NullPointerException();
          }
          ensureMediasIsMutable();
          medias_.add(index, value);
          onChanged();
        } else {
          mediasBuilder_.addMessage(index, value);
        }
        return this;
      }
      /**
       * <code>repeated .com.yumfee.extremeworld.proto.MediaDTO medias = 2;</code>
       */
      public Builder addMedias(
          com.yumfee.extremeworld.proto.MediaProto.MediaDTO.Builder builderForValue) {
        if (mediasBuilder_ == null) {
          ensureMediasIsMutable();
          medias_.add(builderForValue.build());
          onChanged();
        } else {
          mediasBuilder_.addMessage(builderForValue.build());
        }
        return this;
      }
      /**
       * <code>repeated .com.yumfee.extremeworld.proto.MediaDTO medias = 2;</code>
       */
      public Builder addMedias(
          int index, com.yumfee.extremeworld.proto.MediaProto.MediaDTO.Builder builderForValue) {
        if (mediasBuilder_ == null) {
          ensureMediasIsMutable();
          medias_.add(index, builderForValue.build());
          onChanged();
        } else {
          mediasBuilder_.addMessage(index, builderForValue.build());
        }
        return this;
      }
      /**
       * <code>repeated .com.yumfee.extremeworld.proto.MediaDTO medias = 2;</code>
       */
      public Builder addAllMedias(
          java.lang.Iterable<? extends com.yumfee.extremeworld.proto.MediaProto.MediaDTO> values) {
        if (mediasBuilder_ == null) {
          ensureMediasIsMutable();
          com.google.protobuf.AbstractMessageLite.Builder.addAll(
              values, medias_);
          onChanged();
        } else {
          mediasBuilder_.addAllMessages(values);
        }
        return this;
      }
      /**
       * <code>repeated .com.yumfee.extremeworld.proto.MediaDTO medias = 2;</code>
       */
      public Builder clearMedias() {
        if (mediasBuilder_ == null) {
          medias_ = java.util.Collections.emptyList();
          bitField0_ = (bitField0_ & ~0x00000002);
          onChanged();
        } else {
          mediasBuilder_.clear();
        }
        return this;
      }
      /**
       * <code>repeated .com.yumfee.extremeworld.proto.MediaDTO medias = 2;</code>
       */
      public Builder removeMedias(int index) {
        if (mediasBuilder_ == null) {
          ensureMediasIsMutable();
          medias_.remove(index);
          onChanged();
        } else {
          mediasBuilder_.remove(index);
        }
        return this;
      }
      /**
       * <code>repeated .com.yumfee.extremeworld.proto.MediaDTO medias = 2;</code>
       */
      public com.yumfee.extremeworld.proto.MediaProto.MediaDTO.Builder getMediasBuilder(
          int index) {
        return getMediasFieldBuilder().getBuilder(index);
      }
      /**
       * <code>repeated .com.yumfee.extremeworld.proto.MediaDTO medias = 2;</code>
       */
      public com.yumfee.extremeworld.proto.MediaProto.MediaDTOOrBuilder getMediasOrBuilder(
          int index) {
        if (mediasBuilder_ == null) {
          return medias_.get(index);  } else {
          return mediasBuilder_.getMessageOrBuilder(index);
        }
      }
      /**
       * <code>repeated .com.yumfee.extremeworld.proto.MediaDTO medias = 2;</code>
       */
      public java.util.List<? extends com.yumfee.extremeworld.proto.MediaProto.MediaDTOOrBuilder> 
           getMediasOrBuilderList() {
        if (mediasBuilder_ != null) {
          return mediasBuilder_.getMessageOrBuilderList();
        } else {
          return java.util.Collections.unmodifiableList(medias_);
        }
      }
      /**
       * <code>repeated .com.yumfee.extremeworld.proto.MediaDTO medias = 2;</code>
       */
      public com.yumfee.extremeworld.proto.MediaProto.MediaDTO.Builder addMediasBuilder() {
        return getMediasFieldBuilder().addBuilder(
            com.yumfee.extremeworld.proto.MediaProto.MediaDTO.getDefaultInstance());
      }
      /**
       * <code>repeated .com.yumfee.extremeworld.proto.MediaDTO medias = 2;</code>
       */
      public com.yumfee.extremeworld.proto.MediaProto.MediaDTO.Builder addMediasBuilder(
          int index) {
        return getMediasFieldBuilder().addBuilder(
            index, com.yumfee.extremeworld.proto.MediaProto.MediaDTO.getDefaultInstance());
      }
      /**
       * <code>repeated .com.yumfee.extremeworld.proto.MediaDTO medias = 2;</code>
       */
      public java.util.List<com.yumfee.extremeworld.proto.MediaProto.MediaDTO.Builder> 
           getMediasBuilderList() {
        return getMediasFieldBuilder().getBuilderList();
      }
      private com.google.protobuf.RepeatedFieldBuilder<
          com.yumfee.extremeworld.proto.MediaProto.MediaDTO, com.yumfee.extremeworld.proto.MediaProto.MediaDTO.Builder, com.yumfee.extremeworld.proto.MediaProto.MediaDTOOrBuilder> 
          getMediasFieldBuilder() {
        if (mediasBuilder_ == null) {
          mediasBuilder_ = new com.google.protobuf.RepeatedFieldBuilder<
              com.yumfee.extremeworld.proto.MediaProto.MediaDTO, com.yumfee.extremeworld.proto.MediaProto.MediaDTO.Builder, com.yumfee.extremeworld.proto.MediaProto.MediaDTOOrBuilder>(
                  medias_,
                  ((bitField0_ & 0x00000002) == 0x00000002),
                  getParentForChildren(),
                  isClean());
          medias_ = null;
        }
        return mediasBuilder_;
      }

      // @@protoc_insertion_point(builder_scope:com.yumfee.extremeworld.proto.MediaWrapDTO)
    }

    static {
      defaultInstance = new MediaWrapDTO(true);
      defaultInstance.initFields();
    }

    // @@protoc_insertion_point(class_scope:com.yumfee.extremeworld.proto.MediaWrapDTO)
  }

  private static final com.google.protobuf.Descriptors.Descriptor
    internal_static_com_yumfee_extremeworld_proto_MediaWrapDTO_descriptor;
  private static
    com.google.protobuf.GeneratedMessage.FieldAccessorTable
      internal_static_com_yumfee_extremeworld_proto_MediaWrapDTO_fieldAccessorTable;

  public static com.google.protobuf.Descriptors.FileDescriptor
      getDescriptor() {
    return descriptor;
  }
  private static com.google.protobuf.Descriptors.FileDescriptor
      descriptor;
  static {
    java.lang.String[] descriptorData = {
      "\n\022MediaWrapDTO.proto\022\035com.yumfee.extreme" +
      "world.proto\032\016MediaDTO.proto\"[\n\014MediaWrap" +
      "DTO\022\022\n\ncreateTime\030\001 \002(\t\0227\n\006medias\030\002 \003(\0132" +
      "\'.com.yumfee.extremeworld.proto.MediaDTO" +
      "B/\n\035com.yumfee.extremeworld.protoB\016Media" +
      "WrapProto"
    };
    com.google.protobuf.Descriptors.FileDescriptor.InternalDescriptorAssigner assigner =
        new com.google.protobuf.Descriptors.FileDescriptor.    InternalDescriptorAssigner() {
          public com.google.protobuf.ExtensionRegistry assignDescriptors(
              com.google.protobuf.Descriptors.FileDescriptor root) {
            descriptor = root;
            return null;
          }
        };
    com.google.protobuf.Descriptors.FileDescriptor
      .internalBuildGeneratedFileFrom(descriptorData,
        new com.google.protobuf.Descriptors.FileDescriptor[] {
          com.yumfee.extremeworld.proto.MediaProto.getDescriptor(),
        }, assigner);
    internal_static_com_yumfee_extremeworld_proto_MediaWrapDTO_descriptor =
      getDescriptor().getMessageTypes().get(0);
    internal_static_com_yumfee_extremeworld_proto_MediaWrapDTO_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessage.FieldAccessorTable(
        internal_static_com_yumfee_extremeworld_proto_MediaWrapDTO_descriptor,
        new java.lang.String[] { "CreateTime", "Medias", });
    com.yumfee.extremeworld.proto.MediaProto.getDescriptor();
  }

  // @@protoc_insertion_point(outer_class_scope)
}